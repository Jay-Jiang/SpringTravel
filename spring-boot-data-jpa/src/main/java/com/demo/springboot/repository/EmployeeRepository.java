package com.demo.springboot.repository;

import com.demo.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author - Jianghj
 * @since - 2019-12-14 15:37
 * 编写接口：直接继承 JpaRepository 来操作数据层，包含 crud 、分页、排序等功能
 * JpaRepository<T, ID>：
 *     T：表示操作的实体类，也是需要操作的数据表
 *     ID：表示实体类的主键属性的数据类型
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
