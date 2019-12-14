package com.demo.springboot.service;

import com.demo.springboot.entity.Department;
import com.demo.springboot.dao.DeptDao;
import com.demo.springboot.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-12-11 15:44
 */
@Service
public class DeptService {
	/**
	 * 使用 JdbcTemplate 实现数据库访问
	 */
	@Resource
	DeptDao deptDao;

	/**
	 * 纯注解方式：使用 Mybatis 实现数据库访问
	 */
	@Resource
	DepartmentMapper deptMapper;

	public List<Department> getDepts() {
		return deptDao.selectAllDepts();
	}

	public Department addNewDept(Department dept) {
		deptMapper.insertDept(dept);
		return dept;
	}

	public int removeDept(Long id) {
		return deptMapper.deleteDeptById(id);
	}

	public int updateDept(Department dept) {
		return deptMapper.updateDeptById(dept);
	}

	public Department getDept(Long id) {
		return deptMapper.selectDeptById(id);
	}
}
