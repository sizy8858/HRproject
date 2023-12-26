package com.hr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.service.EmployeesService;



/**
 * Servlet implementation class EmployeesController
 */
@WebServlet("*.employees")
public class EmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("URI: " + uri);
		
		String conPath = request.getContextPath();
		System.out.println("conPath: " + conPath);
		
		String command = uri.substring(conPath.length());
		System.out.println("command: " + command);
		
		String viewPage = "selectAll.jsp";
		if(command.equals("/Employees/insert.employees")) {
			viewPage = "insert.jsp";
			System.out.println("/Employees/insert.employees");
		} else if(command.equals("/Employees/insertDB.employees")) {
			viewPage = "selectAll.employees";
			EmployeesService.insertDB(request, response);
			System.out.println("/Employees/insertDB.employees");
		} else if(command.equals("/Employees/selectAll.employees")) {
			viewPage = "selectAll.jsp";
			EmployeesService.selectAll(request, response);
			System.out.println("/Employees/selectAll.employees");
		} else if(command.equals("/Employees/selectOne.employees")) {
			viewPage = "selectOne.jsp";
			EmployeesService.selectId(request, response);
			System.out.println("/Employees/selectOne.employees");
		} else if(command.equals("/Employees/delete.employees")) { 
			viewPage ="selectAll.employees";
			EmployeesService.delete(request,response); 
			System.out.println("/Employees/delete.employees");
		} else if(command.equals("/Employees/update.employees")) {
			viewPage = "update.jsp";
			EmployeesService.selectId(request, response);
			System.out.println("/Employees/update.employees");
		} else if(command.equals("/Employees/updateDB.employees")) {
			viewPage = "selectAll.employees";
			EmployeesService.updateEmail(request, response);
			System.out.println("/Employees/updateDB.employees");
		}
		System.out.println(viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}