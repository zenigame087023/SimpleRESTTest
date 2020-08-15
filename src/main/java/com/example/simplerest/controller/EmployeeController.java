package com.example.simplerest.controller;

import com.example.simplerest.model.Employee;
import com.example.simplerest.model.EmployeeWithDepartmentName;
import com.example.simplerest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public Page<EmployeeWithDepartmentName> getEmployees(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) String age,
            @RequestParam(name = "departmentName", required = false) String departmentName
    ){
        //強制最多10筆
        Pageable pageable = PageRequest.of(page==null?0:page, 10, Sort.by("id"));
        return employeeService.getEmployeesByMultipleCondition(pageable, id,name,age,departmentName);
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployees(
            @RequestBody Employee request
    ){

        Employee employee = employeeService.create(request);

        if(employee==null)ResponseEntity.badRequest().body("創建失敗");

        return ResponseEntity.ok().body(employee);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployees( @RequestBody Employee request
    ){

        Employee employee = employeeService.update(request);

        if(employee==null)ResponseEntity.badRequest().body("更新失敗");

        return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteEmployees(
            @PathVariable("id") String id
        ){
        String result = employeeService.delete(id);
        if("OK".equals(result))return ResponseEntity.ok().body(result);
        else return ResponseEntity.badRequest().body(result);
    }
}
