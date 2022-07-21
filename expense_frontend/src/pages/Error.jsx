import {Button, Container, Table, OverlayTrigger, Popover, Card} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'

export const Error = () => {
    return (
        <Container className="text-center">
        <h1 style={{paddingBottom : 50, paddingTop : 50}}>Page Not Found</h1>
            <Card className="mb-3 text-center" style={{color:'black'}}>
            <Card.Img style={{width :'90%',height: '90%', alignSelf: 'center'  }} src = 'https://www.pngitem.com/pimgs/m/255-2550411_404-error-images-free-png-transparent-png.png'/>
            <Card.Body>
        
            </Card.Body>
            </Card>           
        </Container>
    )
}