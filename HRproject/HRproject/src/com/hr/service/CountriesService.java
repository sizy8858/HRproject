package com.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.CountriesDao;
import com.hr.dto.CountriesDto;

public class CountriesService {
	public static CountriesDao CountriesDao = new CountriesDao();

	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		CountriesDto dto = new CountriesDto(request.getParameter("country_id"),
				Integer.parseInt(request.getParameter("region_id")),
				request.getParameter("country_name"));
			
		System.out.println(dto);
		CountriesDao.insert(dto);
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<CountriesDto> dtos = CountriesDao.selectAll();
		request.setAttribute("dtos", dtos);
	}

	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		CountriesDto dto = CountriesDao.selectId(request.getParameter("country_id"));
		request.setAttribute("dto", dto);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		CountriesDao.delete(request.getParameter("country_id"));
	}

	public static void update(HttpServletRequest request, HttpServletResponse response) {
		CountriesDao.update(request.getParameter("country_id"),request.getParameter("country_name"));
	}
}
