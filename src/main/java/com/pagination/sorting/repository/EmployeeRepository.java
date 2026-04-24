package com.pagination.sorting.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pagination.sorting.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Page<Employee> findByNameContaining(String keyword, Pageable pageable);
}
