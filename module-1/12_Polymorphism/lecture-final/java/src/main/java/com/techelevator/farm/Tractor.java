package com.techelevator.farm;

public class Tractor implements ISingable {
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
