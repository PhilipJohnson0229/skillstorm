import axios from "axios";
import {Button, OverlayTrigger, Popover} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'
// props is an object containing all of the properties passed down by the parent
// Because it's an object, I can destructure out what I want
export const Employee = ({emp, setEmployees, employees}) => {

    const handleUpdate = async (e) => {
        try {
            e.preventDefault();
            await axios.put(`http://localhost:8080/expense-servlet/my-servlet/${emp.id}`);
            setEmployees(employees.filter(employee => emp.id !== employee.id));
        }
        catch (err) {
            console.error(err);
        }
    }
    const handleApprove = async (e) => {
        try {
            e.preventDefault();
            await axios.put(`http://localhost:8080/expense-servlet/my-servlet/${emp.id}`);
            setEmployees(employees.filter(employee => emp.id !== employee.id));
        }
        catch (err) {
            console.error(err);
        }
    }
    const handleDeny = async (e) => {
        try {
            e.preventDefault();
            await axios.put(`http://localhost:8080/expense-servlet/my-servlet/${emp.id}`);
            setEmployees(employees.filter(employee => emp.id !== employee.id));
        }
        catch (err) {
            console.error(err);
        }
    }

    return (
        // Give the text the color of blue
        // inline styles
        <tr>
            <td>{emp.name}</td>
            <td>{emp.reason}</td>
            <td>{emp.notes}</td>
            <td>{emp.statusId}</td>
            <td> 
            <Button variant="success" onClick={handleApprove}>Approve</Button>
            <Button variant="danger" onClick={handleDeny}>Deny</Button>
            </td>
           
        </tr>
    );
}
