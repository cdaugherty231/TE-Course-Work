package com.techelevator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class JDBCExample {

	public static void main(String[] args) throws SQLException {
		
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		
		Connection conn = dataSource.getConnection();
		
		/* Create a Statement object so that we can execute a SQL Query */
		Statement stmt = conn.createStatement();
		
	}
}
