package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		if (bidAmount>0) {
			this.bidAmount = bidAmount;
		}
		else {
			this.bidAmount = 0;
		}
				
	}
	
	public String getBidder() {
		return bidder;
	}
	
	public int getBidAmount() {
		return bidAmount;
	}
}
