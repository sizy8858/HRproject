package com.hr.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.JobHistoryDao;
import com.hr.dto.JobHistoryDto;

public class JobHistoryService {
	public static JobHistoryDao JobHistoryDao = new JobHistoryDao();

	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		JobHistoryDto dto = new JobHistoryDto(LocalDateTime.parse(request.getParameter("start_date")),
				Integer.parseInt(request.getParameter("employee_id")),
				Integer.parseInt(request.getParameter("department_id")),
				request.getParameter("job_id"),
				LocalDateTime.parse(request.getParameter("end_date")));
		System.out.println(dto);
		JobHistoryDao.insert(dto);
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<JobHistoryDto> dtos = JobHistoryDao.selectAll();
		request.setAttribute("dtos", dtos);
	}

	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		JobHistoryDto dto = JobHistoryDao.selectId(request.getParameter("job_id"));
		request.setAttribute("dto", dto);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		JobHistoryDao.delete(request.getParameter("job_id"));
	}

	public static void update(HttpServletRequest request, HttpServletResponse response) {
		JobHistoryDao.updatemMax(request.getParameter("employee_id"),LocalDateTime.parse(request.getParameter("end_date")));
	}
}
