package com.pagination.sorting.service;

import org.springframework.data.domain.Page;

import com.pagination.sorting.dto.EmployeeDto;

public interface EmployeeService {

	Page<EmployeeDto> getEmployees(String keyword, int page, int size, String sortField, String sortDir);

    EmployeeDto save(EmployeeDto dto);

    EmployeeDto getById(Long id);

    void delete(Long id);
}
