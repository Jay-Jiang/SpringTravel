package com.demo.springboot.dao;

import com.demo.springboot.Entity.Department;

import java.util.List;

/**
 * @author - Jianghj
 * @since - 2019-12-11 15:47
 */
public interface DeptDao {

	List<Department> selectAllDepts();

	Department selectDeptById(Long id);

	int insertNewDept(Department department);

	int updateDeptById(Department department);

	int deleteDeptById(Long id);

}
