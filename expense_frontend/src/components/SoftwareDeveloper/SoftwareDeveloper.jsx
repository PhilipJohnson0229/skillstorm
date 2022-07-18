import axios from "axios";
// props is an object containing all of the properties passed down by the parent
// Because it's an object, I can destructure out what I want
export const SoftwareDeveloper = ({dev, color, setDevs, developers}) => {

    const handleDelete = async (e) => {
        try {
            e.preventDefault();
            await axios.delete(`https://my-json-server.typicode.com/skillstorm-walsh/employees-v1/employees/${dev.id}`);
            setDevs(developers.filter(developer => dev.id !== developer.id));
        }
        catch (err) {
            console.error(err);
        }
    }

    return (
        // Give the text the color of blue
        // inline styles
        <tr style={{color: dev.salary < 100000 ? 'red' : 'blue' }}>
            <td>{dev.name}</td>
            <td>{dev.title}</td>
            <td>{dev.salary}</td>
            <button onClick={handleDelete}>Delete</button>
        </tr>
    );
}
// npm i styled-components