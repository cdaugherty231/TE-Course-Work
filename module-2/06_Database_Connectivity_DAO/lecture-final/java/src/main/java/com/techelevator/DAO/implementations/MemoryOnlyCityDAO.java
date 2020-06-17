package com.techelevator.DAO.implementations;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;

public class MemoryOnlyCityDAO implements CityDAO{

	private List<City> allMyCities = new ArrayList<City>();
	long lastUsedCityId=0;
	
	@Override
	public City create(City newCity) {
		newCity.setId(++lastUsedCityId);
		allMyCities.add(newCity);
		return newCity;
	}

	@Override
	public City findCityById(long id) {
		
		for (City c : allMyCities) {
			if (c.getId()==id) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
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
