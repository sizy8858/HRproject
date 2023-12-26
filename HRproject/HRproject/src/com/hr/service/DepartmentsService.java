package com.hr.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.DepartmentsDao;
import com.hr.dto.DepartmentsDto;

public class DepartmentsService {
	public static DepartmentsDao departmentsDao = new DepartmentsDao();
	
	// insert
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		DepartmentsDto dto = new DepartmentsDto(
				Integer.parseInt(request.getParameter("department_id")),
				request.getParameter("department_name"),
				Integer.parseInt(request.getParameter("manager_id")),
				Integer.parseInt(request.getParameter("location_id")));

				
		System.out.println(dto);
		departmentsDao.insert(dto);
	}
	
	// update
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		departmentsDao.update(
				Integer.parseInt(request.getParameter("department_id")),
				Integer.parseInt(request.getParameter("manager_id")));
	}
	
	// delete
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		departmentsDao.delete(Integer.parseInt(request.getParameter("department_id")));
	}
	
	// select
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<DepartmentsDto> dtos = departmentsDao.selectAll();
		request.setAttribute("dtos", dtos);
	}
	
	public static void selectId(HttpServletRequest request, HttpServletResponse response) {
		DepartmentsDto dto = departmentsDao.selectId(
				Integer.parseInt(request.getParameter("department_id")));
		request.setAttribute("dto", dto);		
	}
}
