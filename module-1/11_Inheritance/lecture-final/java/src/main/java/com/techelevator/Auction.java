package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;
    protected boolean isOver; //child classes have access

	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
		isOver = false;
	}
	
	/*
	 * Return true if the bid is the new highest bid, false if not
	 */
	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if(offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}
	
	public Bid getHighBid() {
		return currentHighBid;
	}
	
	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
}
