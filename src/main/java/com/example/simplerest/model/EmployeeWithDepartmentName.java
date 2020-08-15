package com.example.simplerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EmployeeWithDepartmentName extends Employee {


    @Column(name="departmentName")
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
