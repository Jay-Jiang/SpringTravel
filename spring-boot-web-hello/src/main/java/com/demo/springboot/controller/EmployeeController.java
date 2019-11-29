package com.demo.springboot.controller;

import com.demo.springboot.dao.DepartmentDao;
import com.demo.springboot.dao.EmployeeDao;
import com.demo.springboot.entities.Department;
import com.demo.springboot.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author - Jianghj
 * @since - 2019-11-28 10:45
 * 实现 REST 风格的员工 CRUD 操作
 */
@Slf4j
@Controller
public class EmployeeController {

	@Resource
	private EmployeeDao employeeDao;

	@Resource
	private DepartmentDao departmentDao;

	/**
	 * @author - Jhjing
	 * @since - 2019.11.28 028
	 * 获取所有的员工信息
	 */
	@GetMapping("/emps")
	public String list(Model model) {

		Collection<Employee> emps = employeeDao.getAll();
		model.addAttribute("emps", emps);
		return "emp/list";
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.28 028
	 * 跳转添加员工页面
	 */
	@GetMapping("/emp")
	public String toAddEmpPage(Model model) {
		Collection<Department> depts = departmentDao.getDepartments();
		model.addAttribute("depts", depts);
		return "/emp/employee";
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.28 028
	 * 添加新员工
	 */
	@PostMapping("/emp")
	public String addEmp(Employee employee) {
		employeeDao.save(employee);
		log.info("成功添加新的员工：[{}]", employee.toString());
		//保存成功后，重定向到员工列表页面
		return "redirect:/emps";
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.28 028
	 * 跳转修改员工页面
	 */
	@GetMapping("/emp/{empId}")
	public String toModifyEmpPage(Model model, @PathVariable("empId") Integer empId) {
		Employee employee = employeeDao.get(empId);
		Collection<Department> depts = departmentDao.getDepartments();
		model.addAttribute("depts", depts);
		model.addAttribute("emp", employee);
		return "/emp/employee";
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.28 028
	 * 修改员工
	 */
	@PutMapping("/emp")
	public String modifyEmpPage(Employee employee) {
		employeeDao.save(employee);
		log.info("成功修改员工信息：[{}]", employee.toString());
		//修改成功后，重定向到员工列表页面
		return "redirect:/emps";
	}

	/**
	 *@author - Jhjing
	 *@since - 2019.11.28 028
	 * 删除员工
	 */
	@DeleteMapping("/emp/{empId}")
	public String deleteEmp(@PathVariable("empId") Integer empId) {
		employeeDao.delete(empId);
		log.info("成功删除员工：[{}]", empId);
		//删除成功后，重定向到员工列表页面
		return "redirect:/emps";
	}

}
