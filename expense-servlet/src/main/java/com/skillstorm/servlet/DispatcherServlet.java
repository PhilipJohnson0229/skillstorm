package com.skillstorm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*  loadOnStartup = 1 means that we will eagerly
 *  load our servlet and it will be the first to be intialized.
 *  this is good to know in case we DO have multiple servlets
 *  urlPatterns ="/*" means that we will take in every url
 *  */
//@WebServlet(urlPatterns ="/*", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder requestUri = new StringBuilder(req.getRequestURI());
		requestUri.replace(0, 17, "");
		String baseUrl = requestUri.substring(0, requestUri.indexOf("/"));
		System.out.println("GET " + requestUri);
		
		//now we need to map the handlers
		switch(baseUrl) 
		{
			case "employee":
				new EmployeeHandler().returnEmployees();
				break;
			case "reimbursement status":
				new ReimbursementStatus().returnReimbursementStatus();
				break;
			default:
				throw new IllegalArgumentException("Handler not mapped");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}

class EmployeeHandler
{
	public void returnEmployees() 
	{
		System.out.println("return employees called.");
	}
}

class ReimbursementStatus
{
	public void returnReimbursementStatus() 
	{
		System.out.println("return employees reimbursement status called.");
	}
}
