package com.hr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.service.JobsService;

/**
 * Servlet implementation class JobsUserController
 */
@WebServlet("*.jobsUser")
public class JobsUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobsUserController() {
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
		if(command.equals("/Jobs_user/insert.jobsUser")) {
			viewPage = "insert.jsp";
			System.out.println("/Jobs_user/insert.jobsUser");
		} else if(command.equals("/Jobs_user/insertDB.jobsUser")) {
			viewPage = "selectAll.jobsUser";
			JobsService.insertDB(request, response);
			System.out.println("/Jobs_user/insertDB.jobsUser");
		} else if(command.equals("/Jobs_user/selectAll.jobsUser")) {
			viewPage = "selectAll.jsp";
			JobsService.selectAll(request, response);
			System.out.println("/Jobs_user/selectAll.jobsUser");
		} else if(command.equals("/Jobs_user/selectOne.jobsUser")) {
			viewPage = "selectOne.jsp";
			JobsService.selectOne(request, response);
			System.out.println("/Jobs_user/selectOne.jobsUser");

		} else if(command.equals("/Jobs_user/update.jobsUser")) {
			viewPage = "update.jsp";
			JobsService.selectOne(request, response);
			System.out.println("/Jobs_user/update.jobsUser");
		} else if(command.equals("/Jobs_user/updateDB.jobsUser")) {
			viewPage = "selectAll.jobsUser";
			JobsService.updateMax(request, response);
			System.out.println("/Jobs_user/updateDB.jobsUser");
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
