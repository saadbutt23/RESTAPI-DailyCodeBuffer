package com.dailycodebuffer.departmentservice.controller;

import com.dailycodebuffer.departmentservice.model.Department;
import com.dailycodebuffer.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    // to publish logs from Zipkin
    private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
    private DepartmentRepository repository;
    @Autowired
    public DepartmentController(DepartmentRepository dependencyInjectionRepository) {
        this.repository=dependencyInjectionRepository;
    }
@PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add:{}",department);
        // method defined in repository called here via DI
        return repository.addDeparment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }
@GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
    LOGGER.info("Department find: id={}",id);
    return repository.findById(id);
    }
}
