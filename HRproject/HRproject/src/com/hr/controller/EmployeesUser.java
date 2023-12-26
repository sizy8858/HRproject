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
 * Servlet implementation class EmployeesUser
 */
@WebServlet("*.employeeUser")
public class EmployeesUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesUser() {
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
		if(command.equals("/Employee_user/insert.employeeUser")) {
			viewPage = "insert.jsp";
			System.out.println("/Employee_user/insert.employeeUser");
//		} else if(command.equals("/EmpMgrDeptJoin/insertDB.join")) {
//			viewPage = "selectAll.join";
//			EmpMgrDeptService.insertDB(request, response);
//			System.out.println("/EmpMgrDeptJoin/insertDB.join");
		} else if(command.equals("/Employee_user/selectAll.employeeUser")) {
			viewPage = "selectAll.jsp";
			EmployeesService.selectAll(request, response);
			System.out.println("/Employee_user/selectAll.employeeUser");
		} else if(command.equals("/Employee_user/selectOne.employeeUser")) {
			viewPage = "selectOne.jsp";
			EmployeesService.selectId(request, response);
			System.out.println("/Employee_user/selectOne.employeeUser");

		} else if(command.equals("/Employee_user/update.employeeUser")) {
			viewPage = "update.jsp";
			EmployeesService.selectId(request, response);
			System.out.println("/Employee_user/update.employeeUser");
		} 
//			else if(command.equals("/EmpMgrDeptJoin/updateDB.join")) {
//			viewPage = "selectAll.join";
//			EmpMgrDeptService.update(request, response);
//			System.out.println("/EmpMgrDeptJoin/updateDB.join");
//		}
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
