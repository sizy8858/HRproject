package com.hr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.service.DepartmentsService;

/**
 * Servlet implementation class DepartmentsController
 */
@WebServlet("*.departments")
public class DepartmentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsController() {
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
		if(command.equals("/Department/insert.departments")) {
			viewPage = "insert.jsp";
			System.out.println("/Department/insert.departments");
		} else if(command.equals("/Department/insertDB.departments")) {
			viewPage = "selectAll.departments";
			DepartmentsService.insertDB(request, response);
			System.out.println("/Department/insertDB.departments");
		} else if(command.equals("/Department/selectAll.departments")) {
			viewPage = "selectAll.jsp";
			DepartmentsService.selectAll(request, response);
			System.out.println("/Department/selectAll.departments");
		} else if(command.equals("/Department/selectOne.departments")) {
			viewPage = "selectOne.jsp";
			DepartmentsService.selectId(request, response);
			System.out.println("/Department/selectOne.departments");

		} else if(command.equals("/Department/update.departments")) {
			viewPage = "update.jsp";
			DepartmentsService.selectId(request, response);
			System.out.println("/Department/update.departments");
		} else if(command.equals("/Department/updateDB.departments")) {
			viewPage = "selectAll.departments";
			DepartmentsService.update(request, response);
			System.out.println("/Department/updateDB.departments");
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
