package com.pagination.sorting.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.sorting.dto.EmployeeDto;
import com.pagination.sorting.dto.PageResponse;
import com.pagination.sorting.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	private final EmployeeService service;

    public EmployeeRestController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public PageResponse<EmployeeDto> getAll(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortField,
            @RequestParam(defaultValue = "desc") String sortDir
    ) {

        Page<EmployeeDto> pageData =
                service.getEmployees(keyword, page, size, sortField, sortDir);

        return new PageResponse<>(
                pageData.getContent(),
                pageData.getNumber(),
                pageData.getSize(),
                pageData.getTotalElements(),
                pageData.getTotalPages()
        );
    }
}
