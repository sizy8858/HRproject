package com.hr.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.dao.CountriesDao;
import com.hr.dao.LocationDao;
import com.hr.dto.LocationDto;


public class LocationService {
	public static LocationDao locationDao = new LocationDao();
	public static CountriesDao countriesDao = new CountriesDao();
	
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		LocationDto dto = new LocationDto(Integer.parseInt(request.getParameter("location_id")), request.getParameter("countries_id"), request.getParameter("street_address"),request.getParameter("postal_code"),request.getParameter("city"),request.getParameter("state_province"));
		locationDao.insert(dto);
	}
	
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<LocationDto> dtos = locationDao.selectAll();
		request.setAttribute("dtos", dtos);
	}
	
	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		LocationDto dto = locationDao.selectOne(Integer.parseInt(request.getParameter("id")), request.getParameter("hobby"));
		request.setAttribute("dto", dto);
	}
	
	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		locationDao.delete(Integer.parseInt(request.getParameter("location_id")));
	}
	
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		locationDao.update(Integer.parseInt(request.getParameter("location_id")), request.getParameter("city"), request.getParameter("newCity"));
	}
	
	public static void insert(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> ids = countriesDao.getCountry_ids();
		request.setAttribute("ids", ids);
	}
}
