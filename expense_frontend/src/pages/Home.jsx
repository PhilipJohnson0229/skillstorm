import {Button, Container, Table, OverlayTrigger, Popover, Card, Image} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import { ImageBackground, StyleSheet, Text, View} from "react-native";
import TextShadow from '../components/TextShadow';
import { useNavigate } from 'react-router-dom';


export const Home = () => {
    const image = { uri: "https://www.seekpng.com/png/detail/789-7897839_business-meeting-3-staff-in-human-resource.png" };

    const navigate = useNavigate();

    return (
        // This is how to read environment variables
        // Environment variables are good to toggle between different environments (dev, prod, test, QA)
        <>
            <Container className="text-center" style ={{paddingTop : 30}}>
               
                    <Card className="mb-3 text-center" style={{color:'black'}}>
                    
                   
                    <Card.Body>
                    <ImageBackground source={image} resizeMode="cover" style ={{ height : 400}} >
                    <TextShadow></TextShadow>
                    <Button onClick={() => navigate("/StatusPage")} style={{width: 300, alignSelf: 'center', justifyContent: 'inherit', marginBottom: 50}} variant= 'secondary'>Check your status</Button>
                    </ImageBackground>
                    </Card.Body>
                  
                    </Card>
                       
            </Container>
        </>
    );
}