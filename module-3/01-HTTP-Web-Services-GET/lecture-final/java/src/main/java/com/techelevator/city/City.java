package com.techelevator.city;

public class City {

	private String full_name;
	private int goename_id;
	private long population;
	
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the goename_id
	 */
	public int getGoename_id() {
		return goename_id;
	}
	/**
	 * @param goename_id the goename_id to set
	 */
	public void setGoename_id(int goename_id) {
		this.goename_id = goename_id;
	}
	/**
	 * @return the population
	 */
	public long getPopulation() {
		return population;
	}
	/**
	 * @param population the population to set
	 */
	public void setPopulation(long population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		return "Name: "+full_name+" Population: "+population;
	}
}
