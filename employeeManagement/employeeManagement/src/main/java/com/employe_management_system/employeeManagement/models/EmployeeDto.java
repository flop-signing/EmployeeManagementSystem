package com.employe_management_system.employeeManagement.models;

public record EmployeeDto(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
