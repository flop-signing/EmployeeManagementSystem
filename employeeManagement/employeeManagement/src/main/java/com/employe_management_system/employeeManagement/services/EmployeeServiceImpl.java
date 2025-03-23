package com.employe_management_system.employeeManagement.services;

import com.employe_management_system.employeeManagement.entities.EmployeeDao;
import com.employe_management_system.employeeManagement.models.EmployeeDto;
import com.employe_management_system.employeeManagement.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        EmployeeDao employeeDao = new EmployeeDao();


        // Copy all the properties of EmployeeDto to EmployeeDao for saving
        BeanUtils.copyProperties(employeeDto, employeeDao);
        employeeRepository.save(employeeDao);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDao> employeeDtos = employeeRepository.findAll();

        List<EmployeeDto> employeeDtoList = employeeDtos
                .stream()
                .map(employee -> new EmployeeDto(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getEmail()))
                .collect(Collectors.toList());

        return employeeDtoList;
    }

    @Override
    public Boolean deleteEmployee(Integer id) {
        EmployeeDao employeeDao = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeDao);
        return true;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        EmployeeDao employeeDao = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return new EmployeeDto(employeeDao.getEmployeeId(), employeeDao.getFirstName(), employeeDao.getLastName(), employeeDao.getEmail());


    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employee) {

        EmployeeDao employeeDao = employeeRepository.findById(id).get();
        employeeDao.setEmail(employee.email());
        employeeDao.setFirstName(employee.firstName());
        employeeDao.setLastName(employee.lastName());

        employeeRepository.save(employeeDao);

        return employee;
    }
}
