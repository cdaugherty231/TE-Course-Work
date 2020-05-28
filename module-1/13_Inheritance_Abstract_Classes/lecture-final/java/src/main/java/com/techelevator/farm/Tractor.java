package com.techelevator.farm;

public class Tractor implements Singable {
	public Tractor() {
		
	}

	@Override
	public String getName() {
		return "tractor";
	}

	@Override
	public String getSound() {

		return "vroom";
	}

}
