package com.techelevator.DAO.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;

//THIS IS THE ONLY CLASS WHERE SQL STATEMENTS TO ACCESS CITY TABLE SHOULD LIVE

public class JDBCCityDAO implements CityDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityDAO (DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public City create(City newCity) {
		String sql = "INSERT INTO city (name, countrycode, district, population) " +
				 "VALUES (?,?,?,?) RETURNING id";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql,newCity.getName(), newCity.getCountryCode(),newCity.getState(),newCity.getPopulation());
		if (result.next()) {
			newCity.setId(result.getLong("id"));
		}
		return newCity;
	}

	@Override
	public City findCityById(long id) {
		City foundCity = null;
		
		String sqlFindCityById = "SELECT id, name, countrycode, district, population " +
				  "FROM city " +
				  "WHERE id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById,id);
		
		if (results.next()) {
			foundCity = mapRowToCity(results);
		}
		
		return foundCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {

		List<City> foundCities = new ArrayList<>(); 
		
		String sql = "SELECT id,name,countrycode,district,population " + 
		             "FROM city "+
				     "WHERE countrycode = ?;" ; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,countryCode.toUpperCase());
		while (results.next()) {
			City c = mapRowToCity(results);
			foundCities.add(c);
		}
		
		return foundCities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		String sql = "UPDATE city" + 
				"    SET name = ?," + 
				"    countrycode = ?," + 
				"    district = ?," + 
				"    population = ?" + 
				"  WHERE id = ?";
		jdbcTemplate.update(sql,city.getName(),city.getCountryCode(),city.getState(),city.getPopulation(),
				city.getId());
		
	}

	@Override
	public void delete(long id) {
		/* This would work but is vulnerable to SQL Injection
		String sql = "DELETE FROM city WHERE id = " + id;
		jdbcTemplate.update(sql);
		*/
		
		String sql = "DELETE FROM city WHERE id = ?" ; 
		jdbcTemplate.update(sql,id);
		
	}


	/**
	 * @param results
	 * @return
	 */
	private City mapRowToCity(SqlRowSet results) {
		City foundCity = new City();
		foundCity.setId(results.getLong("id"));
		foundCity.setName(results.getString("name"));
		foundCity.setCountryCode(results.getString("countrycode"));
		foundCity.setState(results.getString("district"));
		foundCity.setPopulation(results.getInt("population"));
		return foundCity;
	}

}
