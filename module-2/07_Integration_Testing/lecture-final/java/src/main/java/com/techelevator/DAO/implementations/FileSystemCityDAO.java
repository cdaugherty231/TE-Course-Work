package com.techelevator.DAO.implementations;

import java.util.List;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;

public class FileSystemCityDAO implements CityDAO{
	
	private String fileName = "Cities.txt";


	@Override
	public City create(City newCity) {
		//open the file for writing
		//add a line for the new city
		//close the file
		return newCity;
	}

	@Override
	public City findCityById(long id) {
		//open the file for readign
		//read one line at a time until I find a city that matches the id
		//then close the file and return that city
		return null;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		//create an empty list to return
		//open the file for readign
				//read one line at a time 
		//      if I find a city that matches the countrycode add it to the list
		//then close the file and return the list of cities
		return null;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
