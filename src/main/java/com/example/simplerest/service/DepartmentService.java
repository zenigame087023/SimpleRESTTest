package com.example.simplerest.service;


import com.example.simplerest.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService
{
    List<Department> getAll();

    Department create(Department department);

    Department update(Department department);

    String delete(String departmentId);
}
