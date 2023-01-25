package com.crud.EmployeeMgtBackend.controller;

import com.crud.EmployeeMgtBackend.ValidatorInterface.EmployeeValidator;
import com.crud.EmployeeMgtBackend.criteriaQuery.EmployeeRepo;
import com.crud.EmployeeMgtBackend.entities.Employee;
import com.crud.EmployeeMgtBackend.entities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeValidator  employeeValidator;
    @Autowired
    private EmployeeRepo employeeRepo;

    @InitBinder("Employee")
    public void initBinder(WebDataBinder binder) {

        binder.setValidator(employeeValidator);

    }

    // Get All Employee Rest Api
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return new ResponseEntity<List<Employee>>(employeeRepo.findAll(),HttpStatus.OK);
    }

     //Get Employee By id Rest Api
    @GetMapping("/employeeById")
    public ResponseEntity<Employee> getEmployeeByID(@RequestParam("id") int id)
    {
        Employee employee = (Employee) employeeRepo.findById(id);
        return ResponseEntity.ok(employee);
    }

    //Criteria API
    @GetMapping("employeeByName")
    public List<Employee> findByFirstName (@RequestParam("firstName") String firstName)
    {
        return employeeRepo.findByFirstName(firstName);
    }

    //Create Employee Rest Api
    @PostMapping("/employees/save")
    //public Employee createEmployee(@RequestBody Employee employee)
    public ResponseEntity<?>createEmployee(@Valid @RequestBody Employee employee, Errors errors)
    {
//        return employeeRepository.save(employee);
        if (errors.hasErrors()) {

            return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.CREATED);
    }


    //Delete Employee Rest Api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int id){
        Employee employee = employeeRepo.findById(id);
        employeeRepo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    //Update Employee Rest Api
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeDetails){
        Employee employee = new Employee();
        employeeRepo.update(employeeDetails);
        return new ResponseEntity<Employee>(employeeDetails,HttpStatus.OK);

    }

//    @GetMapping("/employee/{limit}/{offset}")
//    public ResponseEntity<List<Employee>> getResultList(@PathVariable int limit,@PathVariable int offset)
//    {
//        return new ResponseEntity<List<Employee>>(employeeRepo.findAll(new Pagination(limit,offset,"desc","id")),HttpStatus.OK);
//    }

    @PostMapping("employees/pagination")
    public List<Employee>FindAll(@RequestBody Pagination pagination){
        return this.employeeRepo.findAll(pagination);
    }


}
