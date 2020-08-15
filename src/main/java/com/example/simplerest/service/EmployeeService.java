package com.example.simplerest.service;


import com.example.simplerest.model.Department;
import com.example.simplerest.model.Employee;
import com.example.simplerest.model.EmployeeWithDepartmentName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {


    Page<EmployeeWithDepartmentName> getEmployeesByMultipleCondition(Pageable pageable,
                                                                     String id,
                                                                     String name,
                                                                     String age,
                                                                     String department_name);


    Employee create(Employee employee);

    Employee update(Employee employee);

    String delete(String employeeId);

}
