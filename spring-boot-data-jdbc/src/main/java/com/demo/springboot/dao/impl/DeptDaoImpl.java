package com.demo.springboot.dao.impl;

import com.demo.springboot.Entity.Department;
import com.demo.springboot.dao.DeptDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-12-11 15:48
 */

@Repository
public class DeptDaoImpl implements DeptDao {

	@Resource
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Department> selectAllDepts() {
		String sql = " select id,dept_name from department ";
		return jdbcTemplate.query(sql, (rs, i) -> {
			Department dept = new Department();
			dept.setId(rs.getLong("id"));
			dept.setDeptName(rs.getString("dept_name"));
			return dept;
		});
	}

	@Override
	public Department selectDeptById(Long id) {
		return null;
	}

	@Override
	public int insertNewDept(Department department) {
		return 0;
	}

	@Override
	public int updateDeptById(Department department) {
		return 0;
	}

	@Override
	public int deleteDeptById(Long id) {
		return 0;
	}
}
