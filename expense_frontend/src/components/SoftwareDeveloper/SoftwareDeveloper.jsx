import axios from "axios";
import {Button, Container, Row, Column, Table, Col} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'

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
        <Row style={{color: dev.salary < 100000 ? 'red' : 'blue' }}>
            <Col>{dev.name}</Col>
            <Col>{dev.title}</Col>
            <Col>{dev.salary}</Col>
            <Button onClick={handleDelete}>Delete</Button>
        </Row>
    );
}
// npm i styled-components