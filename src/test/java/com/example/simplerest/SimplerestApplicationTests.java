package com.example.simplerest;

import com.example.simplerest.dao.DepartmentDao;
import com.example.simplerest.dao.EmployeeDao;
import com.example.simplerest.model.Department;
import com.example.simplerest.model.Employee;
import com.example.simplerest.service.DepartmentService;
import com.example.simplerest.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class SimplerestApplicationTests {


	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentDao departmentDao;

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeDao employeeDao;

	@Test
	void createDepartmentSuccess() {

		Department request = new Department("D005","營業部");

		when( departmentDao.save(request)).thenReturn(request);

		//未重複創建
		when( departmentDao.findById(request.getId())).thenReturn(Optional.empty());

		Department department = departmentService.create(request);

		assertEquals(request,department);
	}



	@Test
	void createDepartmentFail() {

		Department request = new Department("D005","營業部");

		when( departmentDao.save(request)).thenReturn(null);

		//重複創建
		when( departmentDao.findById(request.getId())).thenReturn(Optional.of(request));

		Department department = departmentService.create(request);

		assertEquals(null,department);
	}

	@Test
	void updateDepartmentSuccess() {

		Department request = new Department("D004","超級法務部");


		when( departmentDao.save(request)).thenReturn(request);

		//更新時找得到目標
		when( departmentDao.findById(request.getId())).thenReturn(Optional.of(request));

		Department department = departmentService.update(request);

		assertEquals(request, department);
	}


	@Test
	void updateDepartmentFail() {

		Department request = new Department("D004","超級法務部");


		when( departmentDao.save(request)).thenReturn(request);
		//更新時找不到目標
		when( departmentDao.findById(request.getId())).thenReturn(Optional.empty());

		Department department = departmentService.update(request);

		assertEquals(null ,department);
	}

	@Test
	void deleteDepartmentSuccess() {

		Department request = new Department("D004","法務部");

		//沒人在部門下
		when( employeeDao.findByDepartmentId(request.getId())).thenReturn(new ArrayList<Employee>());

		String result = departmentService.delete(request.getId());

		assertEquals("OK", result);
	}

	@Test
	void deleteDepartmentFail() {

		Department request = new Department("D004","法務部");

		doThrow(new RuntimeException()).when(departmentDao).deleteById(request.getId());

		//沒人在部門下
		when( employeeDao.findByDepartmentId(request.getId())).thenReturn(new ArrayList<>());

		String result = departmentService.delete(request.getId());

		assertEquals("刪除失敗" ,result);
	}

	@Test
	void deleteDepartmentFailWhenEmployeeBelongThis() {

		Department request = new Department("D004","法務部");

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee());
		//有人在部門下
		when( employeeDao.findByDepartmentId(request.getId())).thenReturn(empList);

		String result = departmentService.delete(request.getId());

		assertEquals("尚有員工在此部門" ,result);
	}

	@Test
	void createEmployeeSuccess() {

		Employee request = new Employee("E00001","謝永強", "D001", 25, "M" ,"0913000000", "OO市XX區OO里XX路250號",new Date(),new Date());

		when( employeeDao.save(request)).thenReturn(request);

		//未重複創建
		when( employeeDao.findById(request.getId())).thenReturn(Optional.empty());

		Employee employee = employeeService.create(request);

		assertEquals(request,employee);
	}



	@Test
	void createEmployeeFail() {

		Employee request = new Employee("E00001","謝永強", "D001", 25, "M" ,"0913000000", "OO市XX區OO里XX路250號",new Date(),new Date());

		when( employeeDao.save(request)).thenReturn(request);

		//未重複創建
		when( employeeDao.findById(request.getId())).thenReturn(Optional.of(request));

		Employee employee = employeeService.create(request);

		assertEquals(null,employee);

	}


	@Test
	void updateEmployeeSuccess() {

		Employee request = new Employee("E00009","屋大維", "D003", 32, "M" ,"0913000000", "OO市XX區OO里XX路254號",new Date(),new Date());

		when( employeeDao.save(request)).thenReturn(request);

		//更新時找得到目標
		when( employeeDao.findById(request.getId())).thenReturn(Optional.of(request));

		Employee employee = employeeService.update(request);

		assertEquals(request, employee);
	}


	@Test
	void updateEmployeeFail() {

		Employee request = new Employee("E00009","屋大維", "D003", 32, "M" ,"0913000000", "OO市XX區OO里XX路254號",new Date(),new Date());

		when( employeeDao.save(request)).thenReturn(request);
		//更新時找不到目標
		when( employeeDao.findById(request.getId())).thenReturn(Optional.empty());

		Employee employee = employeeService.update(request);

		assertEquals(null ,employee);
	}

	@Test
	void deleteEmployeeSuccess() {

		Employee request = new Employee("E00009","屋大維", "D003", 32, "M" ,"0913000000", "OO市XX區OO里XX路254號",new Date(),new Date());

		String result = employeeService.delete(request.getId());

		assertEquals("OK", result);
	}

	@Test
	void deleteEmployeeFail() {

		Employee request = new Employee("E00009","屋大維", "D003", 32, "M" ,"0913000000", "OO市XX區OO里XX路254號",new Date(),new Date());

		doThrow(new RuntimeException()).when(employeeDao).deleteById(request.getId());

		String result = employeeService.delete(request.getId());

		assertEquals("刪除失敗" ,result);
	}


}
