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
 * Servlet implementation class DepartmentsAdminServlet
 */
@WebServlet("*.deptAdmin")
public class DepartmentsAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsAdminServlet() {
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
		if(command.equals("/Department_admin/insert.deptAdmin")) {
			viewPage = "insert.jsp";
			System.out.println("/Department_admin/insert.deptAdmin");
		} else if(command.equals("/Department_admin/insertDB.deptAdmin")) {
			viewPage = "selectAll.deptAdmin";
			DepartmentsService.insertDB(request, response);
			System.out.println("/Department_admin/insertDB.deptAdmin");
		} else if(command.equals("/Department_admin/selectAll.deptAdmin")) {
			viewPage = "selectAll.jsp";
			DepartmentsService.selectAll(request, response);
			System.out.println("/Department_admin/selectAll.deptAdmin");
		} else if(command.equals("/Department_admin/selectOne.deptAdmin")) {
			viewPage = "selectOne.jsp";
			DepartmentsService.selectId(request, response);
			System.out.println("/Department_admin/selectOne.deptAdmin");
		} else if(command.equals("/Department_admin/update.deptAdmin")) {
			viewPage = "update.jsp";
			DepartmentsService.selectId(request, response);
			System.out.println("/Department_admin/update.deptAdmin");
		} else if(command.equals("/Department_admin/updateDB.deptAdmin")) {
			viewPage = "selectAll.deptAdmin";
			DepartmentsService.update(request, response);
			System.out.println("/Department_admin/updateDB.deptAdmin");
		}
		System.out.println(viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
