package com.java.OnetoMany.employee.repository;

import com.java.OnetoMany.employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByEmpId(Long empId);
}
