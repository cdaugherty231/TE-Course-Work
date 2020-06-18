package com.techelevator.city;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import junit.framework.Assert;

public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";
	
	/*
	 * use a single datasource so every database interaction 
	 * is a part of the same session and transaction
	 */
	private static SingleConnectionDataSource dataSource; 
	private JDBCCityDAO dao; 
	
	/* run once before any tests are run */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");//for the sake of time during class. should use env
		
		/* this line disables autocommit for any connections from datasource. This allows us to 
		 * rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}
	
	/* run once after all the tests are run */
	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}
	
	/* befroe each test, let's insert a fake country and a fake city */
	@Before
    public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    jdbcTemplate.update(sqlInsertCountry,TEST_COUNTRY);
	    dao = new JDBCCityDAO(dataSource);
	    
	}

	
	/* this will run after EACH test. 
	 * We will rollback any changes we made for the setup or for the test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void create_a_new_city_and_read_it_back() {
		//arrange
		City theCity = createCity("BarterTown",5000,"Oz");		
		//act - dao
		City createdCity = dao.create(theCity);		
		//YOU MUST READ FROM THE DATABASE AGAIN TO REALLY TEST
		createdCity = dao.findCityById(createdCity.getId());		
		//assert
		Assert.assertTrue(areCitiesEqual(theCity,createdCity));	
	}
	
	//test return cities by country code
	@Test
	public void return_cities_by_country_code() {
		//arrange - TEST_COUNTRY has one city		
		City theCity = createCity("BarterTown",5000,"Oz");
		dao.create(theCity);		
		//act - dao	
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);		
		//assert
		assertNotNull(results);
		assertEquals(1,results.size());
	    assertTrue(areCitiesEqual(theCity,results.get(0)));
		
	}
	
	//test return cities by country code if there are mutliple cities
	@Test
	public void return_multiple_cities_by_country_code() {
		//arrange
		City c1 = createCity("BarterTown",5000,"Oz");
		City c2 = createCity("We love integratino testing",24,"TechElevator");
		dao.create(c1);
		dao.create(c2);
		List<City> expectedResults = new ArrayList<>();
		expectedResults.add(c1);
		expectedResults.add(c2);
		
		//act
		List<City> actualResults = dao.findCityByCountryCode(TEST_COUNTRY);
		
		assertEquals(expectedResults.size(),actualResults.size());
		
		for(City c : expectedResults) {
			boolean foundMatch = false;
			for (City ca : actualResults) {
				if (areCitiesEqual(c,ca))
				{
					foundMatch = true;
					break;
				}				
			}
		    assertTrue("Did not find city "+c.getName()+" in results.",foundMatch);
		}
		
	}
	
	@Test
	public void test_delete_city() {
		//add it
		City c = createCity("Gotham",1000000, "New York");
		c = dao.create(c);
		//make sure it's there
		City cityFromDB = dao.findCityById(c.getId());
		assertTrue(areCitiesEqual(c,cityFromDB));
		
		//delete it
		dao.delete(cityFromDB.getId());
		
		//make sure it's gone
		assertNull(dao.findCityById(cityFromDB.getId()));
	}
	
	@Test
	public void test_update_city() {
		//add it
		City c = createCity("Gotham",1000000, "New York"); 
		c = dao.create(c);
		//make sure it's there
		City cityFromDB = dao.findCityById(c.getId());
		assertTrue(areCitiesEqual(c,cityFromDB));
		
		//update it 
		cityFromDB.setPopulation(24);
		dao.update(cityFromDB);
		
		//make sure it's changed 
		City updatedCity = dao.findCityById(cityFromDB.getId());
		assertEquals(24,updatedCity.getPopulation());
		
	}
	
	
	private boolean areCitiesEqual(City c1, City c2) {
		
		//if 1 is null then they both have to be null
		if ( c1==null || c2 == null)
			return c1==null && c2==null;
		
		return c1.getCountryCode().contentEquals(c2.getCountryCode()) &&
		       c1.getName().equals(c2.getName()) &&
		       c1.getPopulation() == c2.getPopulation() &&
		       c1.getState().equals(c2.getState());
	}
	
	/**
	 * 
	 */
	private City createCity(String name, int pop, String state) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setPopulation(pop);
		theCity.setState(state);
		theCity.setCountryCode(TEST_COUNTRY);
		return theCity;
	}
	
}
