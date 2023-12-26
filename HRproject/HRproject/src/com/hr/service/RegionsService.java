package com.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.RegionsDao;
import com.hr.dto.RegionsDto;

public class RegionsService {
	public static RegionsDao regionsDao = new RegionsDao();

	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		RegionsDto dto = new RegionsDto(Integer.parseInt(request.getParameter("region_id")), request.getParameter("region_name"));
		System.out.println(dto);
		regionsDao.insert(dto);
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<RegionsDto> dtos = regionsDao.selectAll();
		request.setAttribute("dtos", dtos);
	}

	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		RegionsDto dto = regionsDao.selectId(Integer.parseInt(request.getParameter("region_id")));
		request.setAttribute("dto", dto);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		regionsDao.delete(Integer.parseInt(request.getParameter("regions_id")));
	}

	public static void update(HttpServletRequest request, HttpServletResponse response) {
		regionsDao.updatem(Integer.parseInt(request.getParameter("region_id")), request.getParameter("region_name"));
	}
}
