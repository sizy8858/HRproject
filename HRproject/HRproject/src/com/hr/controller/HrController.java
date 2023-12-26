package com.hr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.service.EmployeesService;
import com.hr.service.LoginService;

@WebServlet("*.Controller")
public class HrController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HrController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String command = uri.substring(conPath.length());
        String viewPage = "/Login/loginform.jsp";

        if (command.equals("/login.Controller")) {
            viewPage = "/loginform.jsp";

        }else if(command.equals("/Employees/selectAll.employees")) {
            	viewPage = "/Employees/selectAll.jsp";
            }
            else if(command.equals("/Employees/empinsertDB.employees")) {
            	viewPage = "/Employees/selectAll.Controller";
            	EmployeesService.insertDB(request, response);
            }else if(command.equals("/Employees/empselectAll.employees")) {
            	viewPage = "/Employees/empselectAllDB.Controller";
            	System.out.println("1");
            }else if(command.equals("/Employees/empselectAllDB.employees")) {
            	viewPage= "/Employees/selectAll.Controller";
            	EmployeesService.selectAll(request, response);
            	System.out.println("2");
            }
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
