package com.skillstorm.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.skillstorm.data.EmployeeDao;
import com.skillstorm.model.Employee;


//controller glues model to the view


@WebServlet(urlPatterns = "/my-servlet")
public class ExpenseServlet extends HttpServlet { // IS-A servlet(polymorphism)

	//INSTANCE VARIABLES ARE NOT THREAD SAFE
	//so we need to make sure what it's DOING IS thread safe
	private EmployeeDao employeeDao;
	
	public ExpenseServlet() throws SQLException
	{
		super();
	}
	//HTTP request
	//the servelt class gives us CRUD methods
	//GET / my-servlet(url) / java version
	@Override
	public void init() throws ServletException {
		try {
			employeeDao = new EmployeeDao();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello, this is the init() method");
	}
	
	@Override
	public void destroy() {
		System.out.println("Goodbye, this is the destroy() method");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.addHeader("Access-Control-Allow-Origin","http://localhost:3000");
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectWriter ow = objectMapper.writer();
		String json = "";
		//this is how we will gather our json objects
		try {
			json = ow.writeValueAsString(employeeDao.findAll());
		} catch (JsonProcessingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.getWriter().print(json);
		
		resp.setContentType("application/json");
		
	}
	
	//POST 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		InputStream requestBody = req.getInputStream();
		
		//in order to use
		ObjectMapper objectMapper = new ObjectMapper();
		
		//this takes the input stream and parses the json into a java object
		Employee employee = objectMapper.readValue(requestBody, Employee.class); //takes inputstream and converts to object
		
		
		try {	
			
			switch(employee.getStatusId()) 
			{
			case 1:
				employeeDao.update(employee, 1);
				break;
			case 2:
				employeeDao.update(employee, 2);
				break;
			default:
				employeeDao.create(employee);
			}
			
			System.out.println(employee);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
		System.out.println("Calling Delete");
		InputStream requestBody = req.getInputStream();
		
		//in order to use
		ObjectMapper objectMapper = new ObjectMapper();
		
		//this takes the input stream and parses the json into a java object
		Employee employee = objectMapper.readValue(requestBody, Employee.class);
		
		System.out.println(employee);
		try {
			employeeDao.delete(employee.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
}