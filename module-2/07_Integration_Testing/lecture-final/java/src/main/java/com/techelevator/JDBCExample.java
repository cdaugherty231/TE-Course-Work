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
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
	
		
		Connection conn = dataSource.getConnection();
		
		/* Create a Statement object so that we can execute a SQL Query */
		Statement stmt = conn.createStatement();
		
		//SQL command - Try this with VS Code to get it working first
		String filmsUnder90Minutes = "SELECT film_id, title, description, length FROM film WHERE length < 90; ";
		
		//execute the sql command
		ResultSet results = stmt.executeQuery(filmsUnder90Minutes);
		
		while(results.next()) {
			String title = results.getString("title");
			String description = results.getString("description");
			int length = results.getInt("length");
			
			System.out.format("%-25s %-10d\n", title,length);
		}
		
		//we want to know all films starring zero cage
		//SECURITY VULNERABILITY
		
		//String firstName = "Zero'; DROP table film_category; --"; SQL INJECTION ATTACK
		String firstName = "Zero";
		String lastName = "Cage";
		
		String filmsStarringActor = "SELECT title \r\n" + 
				"FROM film f\r\n" + 
				"JOIN film_actor fa ON f.film_id = fa.film_id\r\n" + 
				"JOIN actor a ON a.actor_id = fa.actor_id\r\n" + 
				"WHERE a.first_name = '"+firstName.toUpperCase()+"' and a.last_name = '"+lastName.toUpperCase()+"';";
	   
		results = stmt.executeQuery(filmsStarringActor);
		
		System.out.println("FILMS STARRING ZERO CAGE");
		
		while(results.next()) {
			String title = results.getString("title");
		
			System.out.println(title);
		} 
		
		dataSource.close();
	}
}
