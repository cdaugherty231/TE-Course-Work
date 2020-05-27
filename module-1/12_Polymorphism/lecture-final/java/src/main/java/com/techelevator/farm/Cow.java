package com.techelevator.farm;

import java.math.BigDecimal;

import com.techelevator.store.ISellable;

public class Cow extends FarmAnimal implements ISellable {

	private BigDecimal price;
	
	public Cow() {
		super("Cow", "moo!");
		price = new BigDecimal(100);
	}
	
	public BigDecimal getPrice() {
		return price; 
	}
	public void setPrice(int price) {
		this.price = new BigDecimal(price);
	}

}