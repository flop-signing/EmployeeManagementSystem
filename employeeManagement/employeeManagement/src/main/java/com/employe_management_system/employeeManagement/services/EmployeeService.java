package com.employe_management_system.employeeManagement.services;

import com.employe_management_system.employeeManagement.entities.EmployeeDao;
import com.employe_management_system.employeeManagement.models.EmployeeDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employee);

    List<EmployeeDto> getAll();

    Boolean deleteEmployee(Integer id);

    EmployeeDto getEmployeeById(Integer id);

    EmployeeDto updateEmployee(Integer id, EmployeeDto employee);
}
