package com.demo.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author - Jianghj
 * @since - 2019-12-11 15:11
 * 构建 ORM 关系中的实体类
 */
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name",length = 50)
	private String lastName;

	/**
	 * 当省略 name 属性时，表明字段名和属性名一致
	 */
	@Column
	private String email;

	@Column(name = "gender",length = 1)
	private int gender;

	@Column(name = "dept_id",length = 11)
	private Long deptId;
}
