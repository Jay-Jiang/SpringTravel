package com.demo.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBootDataJdbcApplicationTests {

	@Resource
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {
		//com.zaxxer.hikari.HikariDataSource
		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}


}
