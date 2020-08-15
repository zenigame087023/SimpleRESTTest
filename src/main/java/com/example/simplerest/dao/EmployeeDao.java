package com.example.simplerest.dao;

import com.example.simplerest.model.Employee;
import com.example.simplerest.model.EmployeeWithDepartmentName;
import org.springframework.data.domain.Page;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  EmployeeDao  extends JpaRepository<Employee, String> {

    @Query(value="SELECT * FROM (SELECT e.*,d.name as department_name FROM employee as e LEFT JOIN department as d ON e.department_id = d.id) as e " +
            "WHERE (:id IS NULL OR e.id = :id) AND " +
            "(:name IS NULL OR e.name = :name) AND " +
            "(:age IS NULL OR e.age = :age) AND " +
            "(:department_name IS NULL OR department_name = :department_name)",
    nativeQuery=true)
    Page<EmployeeWithDepartmentName> findEmployeesByMultipleCondition(Pageable pageable,
                                                                      @Param("id") String id,
                                                                      @Param("name") String name,
                                                                      @Param("age") Integer age,
                                                                      @Param("department_name") String department_name);




    List<Employee> findByDepartmentId(String departmentId);
}
