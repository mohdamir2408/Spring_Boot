package com.java.mappingonetone.controller;

import com.java.mappingonetone.dao.AddressRepository;
import com.java.mappingonetone.dao.EmployeeRepository;
import com.java.mappingonetone.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {
    @Autowired
    public EmployeeRepository employeeRepository;


    @Autowired
    public AddressRepository addDao;
    @PostMapping("/saveEmp")
    public ResponseEntity<String> saveEmployees(@RequestBody Employee empData)
    {
        employeeRepository.save(empData);
        return  ResponseEntity.ok("Data Saved");
    }
    @PostMapping("/saveEmployees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData)
    {
        employeeRepository.saveAll(empData);
        return  ResponseEntity.ok("Data Saved");
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees()
    {
        return employeeRepository.findAll();
    }

}
