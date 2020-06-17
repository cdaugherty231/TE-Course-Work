package com.techelevator;

import java.time.LocalDate;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {

		/*
		 * This datasource will be used for creating connections to the database. Below,
		 * we provide the information required to make database connections
		 */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword(System.getenv("DB_PASSWORD"));

		/*
		 * The JdbcTemplate is the main interface we use to interact with databases
		 * using Spring JDBC.
		 */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);

		// SQL command - Try this with VS Code to get it working first
		String filmsUnder90Minutes = "SELECT film_id, title, description, length FROM film WHERE length < 90; ";

		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(filmsUnder90Minutes);
		while (results.next()) {
			String title = results.getString("title");
			String description = results.getString("description");
			int length = results.getInt("length");

			System.out.format("%-25s %-10d\n", title, length);
		}

		// INSERT AN ACTOR
		String first_name = "Salvador";
		String last_name = "Mendoza";
		// parameterized query
		String sqlCreateActor = "INSERT INTO actor (first_name, last_name) VALUES(?,?);";

		// parameters for update are 1. the string that contains the sql, 2. replace the
		// first ? 3. replace the second ? ....
		int countRowsUpdated = dvdstoreJdbcTemplate.update(sqlCreateActor, first_name.toUpperCase(),
				last_name.toUpperCase());
		System.out.println("You have inserted " + countRowsUpdated + " rows.");

		// let's delete karl berry
		try {
			first_name = "Karl";
			last_name = "Berry";
			String sqlDeleteActor = "DELETE FROM actor WHERE first_name = ? AND last_name = ?";
			int count = dvdstoreJdbcTemplate.update(sqlDeleteActor, first_name.toUpperCase(), last_name.toUpperCase());
			System.out.format("%d rows deleted.", count);
		} catch (Exception e) {
			System.out.format("Unable to delete %s: %s ", first_name, e.getMessage());
		}
		
		
		//when is the last time someone actually rented a video?!?
		String sqlLastRental = "SELECT rental_date " + 
				"FROM rental " + 
				"ORDER BY rental_date DESC " + 
				"LIMIT 1; ";
		SqlRowSet lastRentalResult = dvdstoreJdbcTemplate.queryForRowSet(sqlLastRental);
		LocalDate lastRental = null;
		if (lastRentalResult.next()) {
			 lastRental = lastRentalResult.getDate("rental_date").toLocalDate();
		}
		
		if (lastRental != null) {
			System.out.println("\n \n \n \nThe last time a movie was rented is "+lastRental);
		}
	}
}
