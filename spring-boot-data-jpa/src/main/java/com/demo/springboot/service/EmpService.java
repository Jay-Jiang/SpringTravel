package com.demo.springboot.service;

import com.demo.springboot.entity.Employee;
import com.demo.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-12-14 15:57
 */
@Service
public class EmpService {

	@Resource
	EmployeeRepository employeeRepository;

	public Employee getEmp(Long empId) {
		return employeeRepository.getOne(empId);
	}

	public List<Employee> getAllEmps(){
		return employeeRepository.findAll();
	}

	public Employee saveNewEmp(Employee employee) {
		//插入后，返回包含生成主键的 employee 对象
		return employeeRepository.save(employee);
	}
}
