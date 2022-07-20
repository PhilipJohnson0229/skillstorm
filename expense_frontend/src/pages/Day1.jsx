import { useState } from "react";
import { ClassComponent } from "../components/ClassComponent";
import { EmployeeList } from "../components/Employee";
import { FunctionComponent } from "../components/FunctionComponent";
import { SoftwareDeveloperList } from "../components/SoftwareDeveloper";
import {Button, Alert, Breadcrumb, Card, Container, Image} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'

export const Day1 = () => {
    const [shouldRender, setShouldRender] = useState(false);
    
    // Whatever is returned from this function will be rendered to the page
    return (
        // You may only return ONE JSX element per function
        // This is a fragment. Fragments allow us to return multiple JSX elements
        // They do NOT render to the webpage
        <>
            {/*<button onClick={() => setShouldRender(!shouldRender)}>Toggle Components</button>*/}
            
            <Container className="text-center">
            <h1>Reimbursement Status</h1>
                <Card className="mb-3 text-center" style={{color:'black'}}>
                <Card.Img fluid variant = "top" src = 'https://st2.depositphotos.com/3591429/10365/i/450/depositphotos_103657430-stock-photo-business-team-discussing.jpg/100px50'/>
                <Card.Body>
                    <Card.Title color="black">Employees</Card.Title>
                    <EmployeeList />
                </Card.Body>
                </Card>           
            </Container>
            <Alert variant="primary">This is a button</Alert>
            <Button>Test Button</Button>
        </>
    );

    // If we return multiple with no fragment, we'd try to return two things like this (which we can't do)
    // React.createElement("h1", null, "Hello React!");
    // React.createElement("h2", null, "Hello Again!");
}