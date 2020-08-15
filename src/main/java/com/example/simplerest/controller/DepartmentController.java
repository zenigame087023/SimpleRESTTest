package com.example.simplerest.controller;

import com.example.simplerest.model.Department;
import com.example.simplerest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/department")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;


    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getAll();
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @RequestBody Department request
    ){

        Department department = departmentService.create(request);

        if(department==null)ResponseEntity.badRequest().body("創建失敗");

        return ResponseEntity.ok().body(department);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment( @RequestBody Department request
    ){
        Department department = departmentService.update(request);

        if(department==null)ResponseEntity.badRequest().body("更新失敗");

        return ResponseEntity.ok().body(department);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteDepartment(
            @PathVariable("id") String id
    ){

        String result = departmentService.delete(id);
        if("OK".equals(result))return ResponseEntity.ok().body(result);
        else return ResponseEntity.badRequest().body(result);
    }

}
