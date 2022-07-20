import axios from "axios";
import {Button, OverlayTrigger, Popover} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'
// props is an object containing all of the properties passed down by the parent
// Because it's an object, I can destructure out what I want
export const Employee = ({emp, setEmployees, employees}) => {

    const handleDelete = async (e) => {
        try {
            e.preventDefault();
            await axios.delete(`https://my-json-server.typicode.com/skillstorm-walsh/employees-v1/employees/${emp.id}`);
            setEmployees(employees.filter(employee => emp.id !== employee.id));
        }
        catch (err) {
            console.error(err);
        }
    }

    const popover = (
        <Popover id="popover-basic">
          <Popover.Header as="h3">Popover right</Popover.Header>
          <Popover.Body>
            are you sure you want to delete {emp.name}?
          </Popover.Body>
        </Popover>
      );

    return (
        // Give the text the color of blue
        // inline styles
        <tr>
            <td>{emp.name}</td>
            <td>{emp.reason}</td>
            <td>{emp.notes}</td>
            <td> 
            <OverlayTrigger trigger="hover" placement="top" overlay={popover}>
            <Button variant="warning" onClick={handleDelete}>Delete</Button>
            </OverlayTrigger>
            </td>
           
        </tr>
    );
}
// npm i styled-components