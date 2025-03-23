package com.employe_management_system.employeeManagement.repositories;

import com.employe_management_system.employeeManagement.entities.EmployeeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDao, Integer> {
}
