package com.demo.springboot.controller;

import com.demo.springboot.entity.Employee;
import com.demo.springboot.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-12-14 16:00
 */
@RestController
public class EmpController {

	@Resource
	EmpService empService;

	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable("id") Long empId) {
		return empService.getEmp(empId);
	}

	@GetMapping("/emps")
	public List<Employee> getEmps() {
		return empService.getAllEmps();
	}

	@GetMapping("/emp/save/{name}")
	public Employee saveNewEmp(@PathVariable("name") String empName) {
		Employee emp = new Employee();
		emp.setLastName(empName);
		emp.setEmail("1232@xxx.com");
		emp.setGender(0);
		emp.setDeptId(1001L);
		return empService.saveNewEmp(emp);
	}
}
