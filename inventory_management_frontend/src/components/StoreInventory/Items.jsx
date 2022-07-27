import React from 'react';
import axios from 'axios';
import { Container, Table, Card} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { ItemsMap } from './ItemsMap';
import { useState, useEffect } from 'react';
/* This is the webpage that will display the items table. The mapping
of the table is done in a child component -> ItemsMap
*/

export const Items = () => {

    const [table, setTable] = useState([]);

    // retrieves table
    useEffect(() => {
        axios.get(`http://localhost:8080/`)
        .then((response) => {console.log(response.data) 
            setTable(response.data)})
        .catch((err) => {console.log(err)})
    }, []) // every time update is changed -> useEffect hook is called again

 // Bare bones Items table setup, still need to alter
    return (
    <>
    <Container className="text-center"  style={{paddingTop: 30}}>
        <Card>
    <Table striped bordered hover size="sm" variant='light' responsive>
        <thead>
            <tr>
                <td>ID</td>
                <td>Category</td>
                <td>Description</td>
                <td>Price</td>
                <td>Store Location</td>
                <td>Action</td>
            </tr>
        </thead>
        <tbody>
            {table.map((e) =>(
                <ItemsMap e={e} setTable={setTable} /> 
                    
            ))}

        </tbody>
    </Table>
    </Card>
    </Container>
    </>
    );
}