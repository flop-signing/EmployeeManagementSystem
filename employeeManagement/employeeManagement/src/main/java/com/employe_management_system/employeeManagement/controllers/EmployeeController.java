package com.employe_management_system.employeeManagement.controllers;

import com.employe_management_system.employeeManagement.models.EmployeeDto;
import com.employe_management_system.employeeManagement.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {


    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping()
    public ResponseEntity<EmployeeDto> create(@RequestBody  EmployeeDto employeeDto) {

        employeeService.create(employeeDto);

        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping()
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Integer id) {
        Boolean deleted=false;
        deleted=employeeService.deleteEmployee(id);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {

        EmployeeDto employeeDto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id ,@RequestBody EmployeeDto employeeDto) {

        EmployeeDto employee=employeeService.updateEmployee(id,employeeDto);

        return ResponseEntity.ok(employee);

    }
}
