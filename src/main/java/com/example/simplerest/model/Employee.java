package com.example.simplerest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    public Employee() {
    }

    public Employee(String id, String name, String departmentId, Integer age, String gender, String telephoneNo, String address, Date createTime, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.age = age;
        this.gender = gender;
        this.telephoneNo = telephoneNo;
        this.address = address;
        this.createTime = createTime;
        this.lastUpdate = lastUpdate;
    }

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="departmentId")
    private String departmentId;

    @Column(name="age")
    private Integer age;

    @Column(name="gender")
    private String gender;

    @Column(name="telephoneNo")
    private String telephoneNo;

    @Column(name="address")
    private String address;

    @CreatedDate
    @Column(name="createTime")
    @JsonFormat(timezone = "GMT+08:00")
    private Date createTime;

    @LastModifiedDate
    @Column(name="lastUpdate")
    @JsonFormat(timezone = "GMT+08:00")
    private Date lastUpdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
