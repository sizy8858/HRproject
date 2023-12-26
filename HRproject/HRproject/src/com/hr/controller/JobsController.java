package com.hr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.service.EmployeesService;
import com.hr.service.JobsService;

/**
 * Servlet implementation class JobsUserController
 */
@WebServlet("*.jobs")
public class JobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobsController() {
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
		if(command.equals("/Jobs/insert.jobs")) {
			viewPage = "insert.jsp";
			System.out.println("/Jobs/insert.jobs");
		} else if(command.equals("/Jobs/insertDB.jobs")) {
			viewPage = "selectAll.jobs";
			JobsService.insertDB(request, response);
			System.out.println("/Jobs/insertDB.jobs");
		} else if(command.equals("/Jobs/selectAll.jobs")) {
			viewPage = "selectAll.jsp";
			JobsService.selectAll(request, response);
			System.out.println("/Jobs/selectAll.jobs");
		} else if(command.equals("/Jobs/selectOne.jobs")) {
			viewPage = "selectOne.jsp";
			JobsService.selectOne(request, response);
			System.out.println("/Jobs/selectOne.jobs");
		} else if(command.equals("/Jobs/delete.jobs")) { 
			viewPage ="selectAll.jobs";
			EmployeesService.delete(request,response); 
			System.out.println("/Jobs/delete.jobs");
		} else if(command.equals("/Jobs/update.jobs")) {
			viewPage = "update.jsp";
			JobsService.selectOne(request, response);
			System.out.println("/Jobs/update.jobs");
		} else if(command.equals("/Jobs/updateDB.jobs")) {
			viewPage = "selectAll.jobs";
			JobsService.updateMax(request, response);
			System.out.println("/Jobs/updateDB.jobs");
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
