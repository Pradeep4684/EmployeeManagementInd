package com.pagination.sorting.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pagination.sorting.dto.EmployeeDto;
import com.pagination.sorting.employee.Employee;
import com.pagination.sorting.mapper.EmployeeMapper;
import com.pagination.sorting.repository.EmployeeRepository;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Page<EmployeeDto> getEmployees(String keyword, int page, int size, String sortField, String sortDir) {

        if (page < 0) page = 0;

        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Employee> pageResult = (keyword != null && !keyword.isEmpty())
                ? repo.findByNameContaining(keyword, pageable)
                : repo.findAll(pageable);

        return pageResult.map(EmployeeMapper::toDto);
    }

    @Override
    public EmployeeDto save(EmployeeDto dto) {
        Employee emp = EmployeeMapper.toEntity(dto);
        return EmployeeMapper.toDto(repo.save(emp));
    }

    @Override
    public EmployeeDto getById(Long id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.toDto(emp);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
