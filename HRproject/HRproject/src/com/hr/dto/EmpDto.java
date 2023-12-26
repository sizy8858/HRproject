package com.hr.dto;


public class EmpDto {
	private EmployeesDto employeesDto;
	private DepartmentsDto departmentsDto;
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDto(EmployeesDto employeesDto, DepartmentsDto departmentsDto) {
		super();
		this.employeesDto = employeesDto;
		this.departmentsDto = departmentsDto;
	}
	@Override
	public String toString() {
		return "EmpDto [employeesDto=" + employeesDto + ", departmentsDto=" + departmentsDto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentsDto == null) ? 0 : departmentsDto.hashCode());
		result = prime * result + ((employeesDto == null) ? 0 : employeesDto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpDto other = (EmpDto) obj;
		if (departmentsDto == null) {
			if (other.departmentsDto != null)
				return false;
		} else if (!departmentsDto.equals(other.departmentsDto))
			return false;
		if (employeesDto == null) {
			if (other.employeesDto != null)
				return false;
		} else if (!employeesDto.equals(other.employeesDto))
			return false;
		return true;
	}
	public EmployeesDto getEmployeesDto() {
		return employeesDto;
	}
	public void setEmployeesDto(EmployeesDto employeesDto) {
		this.employeesDto = employeesDto;
	}
	public DepartmentsDto getDepartmentsDto() {
		return departmentsDto;
	}
	public void setDepartmentsDto(DepartmentsDto departmentsDto) {
		this.departmentsDto = departmentsDto;
	}
	
	
}
