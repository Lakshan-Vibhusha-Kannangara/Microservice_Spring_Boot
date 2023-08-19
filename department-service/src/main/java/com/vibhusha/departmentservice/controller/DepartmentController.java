package com.vibhusha.departmentservice.controller;


import com.vibhusha.departmentservice.model.Department;
import com.vibhusha.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository repository;

    @PostMapping()
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add:{}",department);
        return repository.addDepartment(department);

    }
    public List<Department> findAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){

         return repository.findById(id);
    }

}
