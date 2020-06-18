package com.techelevator;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.DAO.implementations.FileSystemCityDAO;
import com.techelevator.DAO.implementations.OracleCityDAO;
import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
		
		/* If i don't want post gres I would change from here */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		
		CityDAO dao = new JDBCCityDAO(dataSource);
		/* to here */
		//CityDAO dao = new OracleCityDAO();
				
		City c = dao.findCityById(55);
		System.out.println("City name: "+ ( (c==null)? "not found!": c.getName()) );
		
		String countryCode = "BRB";
		System.out.println("What all cities are in Barbados?");
		
		List<City> cities = dao.findCityByCountryCode(countryCode);
		for(City city : cities) {
			System.out.println(city.getName() + " "+city.getPopulation());
		}
		
		countryCode = "AUS";
		System.out.println("What all cities are in Australia?");
		
		cities = dao.findCityByCountryCode(countryCode);
		for(City city : cities) {
			System.out.println(city.getName() + " "+city.getPopulation()+ " "+city.getState());
		}
		
		c.setPopulation(23); //ONLY UPDATES THE PROGRAM MEMORY
		dao.update(c); //THIS WILL REALLY UPDATE THE DATABASE
		


	}

}
