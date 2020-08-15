package com.example.simplerest.service;

import com.example.simplerest.dao.DepartmentDao;
import com.example.simplerest.dao.EmployeeDao;
import com.example.simplerest.model.Department;
import com.example.simplerest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Department> getAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department create(Department request) {

        Optional<Department> departmentOptional = departmentDao.findById(request.getId());

        //不重覆創建
        if (departmentOptional.isPresent()) {
            return null;
        }

        return departmentDao.save(request);
    }

    @Override
    public Department update(Department request) {
        Optional<Department> departmentOptional = departmentDao.findById(request.getId());

        //找不到
        if (!departmentOptional.isPresent()) {
            return null;
        }

        Department department = departmentOptional.get();
        if(request.getName()!=null)department.setName(request.getName());

        return departmentDao.save(department);
    }

    @Override
    public String delete(String departmentId) {
        List<Employee> employeeList = employeeDao.findByDepartmentId(departmentId);

        if(employeeList.size()>0)return "尚有員工在此部門";

        try {
            departmentDao.deleteById(departmentId);
        }catch (Exception e)
        {
            return "刪除失敗";
        }
        return "OK";
    }
}
