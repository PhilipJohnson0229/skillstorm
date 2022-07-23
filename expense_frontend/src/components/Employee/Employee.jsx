import axios from "axios";
import {Button, OverlayTrigger, Popover} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css'
import { useState } from "react";
import { useEffect } from "react";

export const Employee = ({emp, setEmployees, employees}) => {

    const handleApprove = async () => {
        try {
            const s = await axios.post(`http://localhost:8080/expense-servlet/my-servlet?id=${emp.id}`, {
                id: emp.id,
                name: emp.name,
                amount: emp.amount,
                reason: emp.reason,
                notes: emp.notes,
                statusId: 1
            }).then(setB(true),);
            if(s)
            {
                axios.get(`http://localhost:8080/expense-servlet/my-servlet`)
            .then(res => setEmployees(res.data));
            }
  
        }catch (err) {
            console.error(err);
        }
    }
    const handleDeny = async (e) => {
        try {
            const s = await axios.post(`http://localhost:8080/expense-servlet/my-servlet?id=${emp.id}`, {
                id: emp.id,
                name: emp.name,
                amount: emp.amount,
                reason: emp.reason,
                notes: emp.notes,
                statusId: 2
            }).then(setB(true),);
            if(s)
            {
                axios.get(`http://localhost:8080/expense-servlet/my-servlet`)
            .then(res => setEmployees(res.data));
            }
  
        }catch (err) {
            console.error(err);
        }
    }
    const handleDelete = async () => {
        try {
            const s = await axios.post(`http://localhost:8080/expense-servlet/my-servlet?id=${emp.id}`, {
            });
            setEmployees(employees.filter(employee => emp.id !== employee.id));
          
  
        }catch (err) {
            console.error(err);
        }
    }

    const [b, setB] = useState(false);

    useEffect(() => {
        if(emp.statusId === 1 || emp.statusId === 2)
        {
            setB(true);
        }
        else
        {
            setB(false);
        }
    })

    return (
        // Give the text the color of blue
        // inline styles
        <tr>
            <td>{emp.name}</td>
            <td colSpan={0.5}>{emp.amount}</td>
            <td>{emp.reason}</td>
            <td>{emp.notes}</td>
            <td>{emp.status.status}</td>
            <td> 
            <Button variant="success" onClick={handleApprove} disabled = {b}>Approve</Button>
            <Button variant="danger" onClick={handleDeny} disabled = {b}>Deny</Button>
            <Button variant="dark" onClick={handleDelete} >Delete</Button>
            </td>
        </tr>
    );
}
