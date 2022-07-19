import axios from "axios";
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

    return (
        // Give the text the color of blue
        // inline styles
        <tr /*style={{color: dev.salary < 100000 ? 'red' : 'blue' }}*/>
            <td>{emp.name}</td>
            <td>{emp.reason}</td>
            <td>{emp.notes}</td>
            <button onClick={handleDelete}>Delete</button>
        </tr>
    );
}
// npm i styled-components