import { useState, useEffect, useRef, useContext } from 'react';
import ThemeContext from '../../contexts/ThemeContext';
import axios from 'axios';
import { SoftwareDeveloper } from './SoftwareDeveloper';

export const SoftwareDeveloperList = () => {
    const [devs, setDevs] = useState([]);
    const [name, setName] = useState('');
    const titleRef = useRef(); // Creates a reference object
    const salaryRef = useRef();

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

    useEffect(() => {
        axios.get(`${process.env.REACT_APP_HOST_URI}/skillstorm-walsh/employees-v1/employees`)
            .then(res => setDevs(res.data)); // sets my devs state to be that array of devs
    }, []); // Be sure this is an empty array
    
    const handleSubmit = async (event) => {
        try {
            event.preventDefault(); // Prevent the default HTML form submission (AKA Reload the page)
            // 1. Extract the data
            // 2. Send out a POST request
            // 3. When you receive the newly created dev id, add it to the dev array
            const { data } = await axios.post('https://my-json-server.typicode.com/skillstorm-walsh/employees-v1/employees',
                {
                    name, // implied that it's name: name
                    // Think of titleRef.current as <input />
                    title: titleRef.current.value,
                    salary: salaryRef.current.value
                }
            );
            console.log(data);
            setDevs([...devs, data]);
            setName('');
            titleRef.current.value = null;
            salaryRef.current.value = '';
        } catch (err) {
            console.error(err);
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <table style={theme}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Title</th>
                        <th>Salary</th>
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
                    {devs.map((dev) => {
                        // Map constructs a new array based off what we return
                        return (
                            // Always use the primary id from the database since it's unique
                            <SoftwareDeveloper key={dev.id} dev={dev} developers={devs} setDevs={setDevs} />
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
                            <td><input name="title" ref={titleRef} placeholder='Please enter Title'/></td>
                            <td><input name="salary" ref={salaryRef} placeholder='Please enter Salary'/></td>
                            <button>Create new Developer!</button>
                    </tr>
                    {/* </form> */}
                </tbody>
            </table>
        </form>
    );
}