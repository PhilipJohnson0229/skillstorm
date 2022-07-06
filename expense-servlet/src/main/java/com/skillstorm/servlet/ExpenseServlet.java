package com.skillstorm.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.EmployeeDao;
import com.skillstorm.model.Employee;


@WebServlet(urlPatterns = "/my-servlet")
public class ExpenseServlet extends HttpServlet { // IS-A servlet(polymorphism)

	private EmployeeDao expenseDao = new EmployeeDao();
	
	//HTTP request
	//the servelt class gives us CRUD methods
	//GET / my-servlet(url) / java version
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		//this is how we will gather our json objects
		String json = om.writeValueAsString(expenseDao.findAll());
		//we will have the objectMapper print out the JSONobjects into java string objects
		resp.getWriter().println(json);
		resp.setContentType("application/json");
	}
	
	//POST 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("postTest"));
		//resp.sendRedirect("response.html");
		//req.getRequestDispatcher("response.html").forward(req, resp); // writes to the response body
		//http requerst body
		/*InputStream requestBody = req.getInputStream();
		
		//in order to use
		ObjectMapper om = new ObjectMapper();
		
		Employee employee = om.readValue(requestBody, Employee.class); //takes inputstream and converts to object
		
		
		
		expenseDao.add(employee);
		
		System.out.println("Employee: " + expenseDao.findAll());*/
	}
	
	//UPDATE
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	//DELETE
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}