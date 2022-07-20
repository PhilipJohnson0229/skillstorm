import { useState, useEffect, useRef, useContext } from 'react';
import ThemeContext from '../../contexts/ThemeContext';
import axios from 'axios';
//import { SoftwareDeveloper } from './SoftwareDeveloper';
import { Employee } from './Employee';
import {Button, Container, Table, OverlayTrigger, Popover} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'

//we will make an api call to our backend
export const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const [name, setName] = useState('');
    const reasonRef = useRef(); // Creates a reference object
    const notesRef = useRef();

    /**
     * useRef hook:
     * 
     * useRef returns a reference object that WILL persist between re-renders similar to useState
     * The key difference though, is that updating a ref, does NOT trigger a re-render
     * 
     * 1. Refs are mutable and I can update them without a setter
     * 2. Mutating a ref does NOT cause a re-render
     * 3. The value is persisted between re-renders
     * 
     * I can also use the ref to refer to a native HTML element (similar to document.getElementById)
     */

    const theme = useContext(ThemeContext);

    //this is where we make our api call with axios/ajax
    //returns a promise
    useEffect(() => {
        axios.get(`http://localhost:8080/expense-servlet/my-servlet`)
            .then(res => setEmployees(res.data)); // sets my devs state to be that array of devs
    }, []); // Be sure this is an empty array
    
    const handleSubmit = async (event) => {
        try {
            event.preventDefault(); // Prevent the default HTML form submission (AKA Reload the page)
            // 1. Extract the data
            // 2. Send out a POST request
            // 3. When you receive the newly created dev id, add it to the dev array
            const { data } = await axios.post('http://localhost:8080/expense-servlet/my-servlet',
                {
                    name, // implied that it's name: name
                    // Think of titleRef.current as <input />
                    reason: reasonRef.current.value,
                    notes: notesRef.current.value
                }
            );
            console.log(data);
            setEmployees([...employees, data]);
            setName('');
            reasonRef.current.value = null;
            notesRef.current.value = '';
        } catch (err) {
            console.error(err);
        }
    }
    
    const popover = (
        <Popover id="popover-basic">
          <Popover.Header as="h3">Popover right</Popover.Header>
          <Popover.Body>
            Are you <strong>sure</strong> you want to submit this record?
          </Popover.Body>
        </Popover>
    );

    return (
        <Container>
        <form onSubmit={handleSubmit}>
            <Table striped bordered hover size="sm" variant='dark'>
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Reason</td>
                        <td>Notes</td>
                        <td>Action</td>
                        {/*when were ready to add the response code column we start here*/}
                    </tr>
                </thead>
                <tbody>
                    {/* I want to dynamically render all of those devs that I received */}
                    {/* <tr> This is the HTML way. Manual typing
                        <td>Dan Pickles</td>
                        <td>Senior Technical Architect</td>
                        <td>100000</td>
                    </tr> */}

                    {/* Use the built in array method, map() to create an array of JSX elements */}
                    {employees.map((emp) => {
                        // Map constructs a new array based off what we return
                        return (
                            // Always use the primary id from the database since it's unique
                            <>
                            {/*<Employee key={emp.id} emp={emp} employees={employees} setEmployees={setEmployees} />*/}
                           
                            
                            <Employee key={emp.id} emp={emp} employees={employees} setEmployees={setEmployees} />
                        
                            </>

                        );
                    })}
                    {/* <form> */}
                    <tr>
                            {/* In React, we should NOT use document.getElementById to access
                                a DOM element.
                                
                                Doing so, bypasses React and all of its optimaztions, instead, we should
                                this React's way
                            */}

                            {/* This is a "controlled component". React is in charge of it */}
                            <td><input name="name" value={name} onChange={(event) => setName(event.target.value)} placeholder='Please enter Name'/></td>
                            
                            {/* This is an "uncontrolled component". React doesn't manage it, it just uses
                                the native DOM to manage state */}
                                {/* When input updates, my ref will also update since it "points" to that input */}
                            <td><input name="reason" ref={reasonRef} placeholder='Please enter reason'/></td>
                            <td><input name="notes" ref={notesRef} placeholder='Please enter any notes'/></td>
                            <td>
                            <OverlayTrigger trigger="hover" placement="top" overlay={popover}>
                            <Button type='submit' variant='primary'>Create Entry</Button>
                            </OverlayTrigger>
                            </td>
                           
                            
                    </tr>
                    {/* </form> */}
                </tbody>
            </Table>
        </form>
        </Container>
    );
    
}