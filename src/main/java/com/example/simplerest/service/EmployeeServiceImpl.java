package com.example.simplerest.service;

import com.example.simplerest.dao.EmployeeDao;
import com.example.simplerest.model.Department;
import com.example.simplerest.model.Employee;
import com.example.simplerest.model.EmployeeWithDepartmentName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;


    @Override
    public Page<EmployeeWithDepartmentName> getEmployeesByMultipleCondition(Pageable pageable, String id, String name, String age, String department_name) {
        return employeeDao.findEmployeesByMultipleCondition(pageable,  id,  name, age==null?null:Integer.valueOf(age),  department_name);
    }

    @Override
    public Employee create(Employee request) {

        Optional<Employee> employeeOptional = employeeDao.findById(request.getId());

        //不重覆創建
        if (employeeOptional.isPresent()) {
            return null;
        }

        request.setLastUpdate(null);
        request.setCreateTime(new Date());

        return employeeDao.save(request);
    }

    @Override
    public Employee update(Employee request) {
        Optional<Employee> employeeOptional = employeeDao.findById(request.getId());

        //找不到
        if (!employeeOptional.isPresent()) {
            return null;
        }

        Employee employee = employeeOptional.get();
        if(request.getAddress()!=null)employee.setAddress(request.getAddress());
        if(request.getAge()!=null)employee.setAge(request.getAge());
        if(request.getDepartmentId()!=null)employee.setDepartmentId(request.getDepartmentId());
        if(request.getGender()!=null)employee.setGender(request.getGender());
        if(request.getName()!=null)employee.setName(request.getName());
        if(request.getTelephoneNo()!=null)employee.setTelephoneNo(request.getTelephoneNo());

        return employeeDao.save(employee);
    }

    @Override
    public String delete(String employeeId) {

        try {
            employeeDao.deleteById(employeeId);
        }catch (Exception e)
        {
            return "刪除失敗";
        }
        return "OK";
    }


}
