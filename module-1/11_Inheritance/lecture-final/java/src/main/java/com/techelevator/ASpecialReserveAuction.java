package com.techelevator;

//everything has 5000 as the reserve
public class ASpecialReserveAuction extends ReserveAuction{

	public ASpecialReserveAuction() {
		super(5000);
	
	}
	
	public ASpecialReserveAuction(String itemName) {
		super(itemName,5000);	
	}

}
