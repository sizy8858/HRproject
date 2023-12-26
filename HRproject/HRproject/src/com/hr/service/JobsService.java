package com.hr.service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hr.dao.JobsDao;
import com.hr.dto.JobsDto;

public class JobsService {
	public static JobsDao JobsDao = new JobsDao();

	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		JobsDto dto = new JobsDto(request.getParameter("job_id"), request.getParameter("job_title"),
				Integer.parseInt(request.getParameter("min_salary")),
				Integer.parseInt(request.getParameter("max_salary")));
		System.out.println(dto);
		JobsDao.insert(dto);
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<JobsDto> dtos = JobsDao.selectAll();
		request.setAttribute("dtos", dtos);
	}

	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		JobsDto dto = JobsDao.selectId(request.getParameter("job_id"));
		request.setAttribute("dto", dto);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		JobsDao.delete(request.getParameter("job_id"));
	}

//	public static void update(HttpServletRequest request, HttpServletResponse response) {
//		JobsDao.update(request.getParameter("job_id"), request.getParameter("job_title"));
//	}
	public static void updateMax(HttpServletRequest request, HttpServletResponse response) {
		JobsDao.update(request.getParameter("job_id"), Integer.parseInt(request.getParameter("min_salary")));
	}
}