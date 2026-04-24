package com.pagination.sorting.mapper;

import com.pagination.sorting.dto.EmployeeDto;
import com.pagination.sorting.employee.Employee;

public class EmployeeMapper {

	 public static EmployeeDto toDto(Employee emp) {
	        return new EmployeeDto(
	                emp.getId(),
	                emp.getName(),
	                emp.getEmail(),
	                emp.getDepartment()
	        );
	    }

	    public static Employee toEntity(EmployeeDto dto) {
	        Employee emp = new Employee();
	        emp.setId(dto.getId());
	        emp.setName(dto.getName());
	        emp.setEmail(dto.getEmail());
	        emp.setDepartment(dto.getDepartment());
	        return emp;
	    }
}
