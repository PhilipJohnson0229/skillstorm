import { useState } from "react";
import { EmployeeList } from "../components/Employee";
import {Button, Alert, Breadcrumb, Card, Container} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'

export const StatusPage = () => {
    //const [shouldRender, setShouldRender] = useState(false);
    
    return (
        // You may only return ONE JSX element per function
        // This is a fragment. Fragments allow us to return multiple JSX elements
        // They do NOT render to the webpage
        <>
            {/*<button onClick={() => setShouldRender(!shouldRender)}>Toggle Components</button>*/}
            
            <Container className="text-center">
            <h1 style={{paddingBottom : 20, paddingTop : 30}}>Reimbursement Status</h1>
                <Card className="mb-3 text-center" style={{color:'black'}}>
                <Card.Img style={{height: '95%', alignSelf: 'center'  }} src = 'https://www.rccd.edu/admin/hrer/dec/PublishingImages/DEC_HERO.jpg'/>
                <Card.Body>
                <EmployeeList />
                </Card.Body>
                </Card>           
            </Container>
        </>
    );
}