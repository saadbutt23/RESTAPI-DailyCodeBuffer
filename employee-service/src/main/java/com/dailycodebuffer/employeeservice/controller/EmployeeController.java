package com.dailycodebuffer.employeeservice.controller;

import com.dailycodebuffer.employeeservice.model.Employee;
import com.dailycodebuffer.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeRepository repository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
@Autowired
    public EmployeeController(EmployeeRepository repositoryInjected) {
        this.repository=repositoryInjected;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
    LOGGER.info("Employee add:{}", employee);
    return repository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
    LOGGER.info("Employee find");
    return repository.findAll();
    }

    @GetMapping("{id}")
    public Employee findbyId(@PathVariable("id") Long id) {
    LOGGER.info("EMployee find: id={}",id);
    return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find:departmentID={}",departmentId);
        return repository.findByDepartment(departmentId);

    }
}
