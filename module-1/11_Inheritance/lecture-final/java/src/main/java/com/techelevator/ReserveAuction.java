package com.techelevator;

// like an auction but only counts bids over the reserve
public class ReserveAuction extends Auction {
	
	private int reserve; 

	public ReserveAuction(String itemForSale, int reserve) {		
		super(itemForSale);		//super calls the parent. MUST BE FIRST
		this.reserve = reserve;
	}
	
	public ReserveAuction(int reserve) {
		//super(); this would be ok IF Auction had a no-arg constructor
		super("some random stuff i'm selling");
		//itemForSale = "bla"; private fields from the parent aren't visible
		isOver = false; //protected fields are visible in children
		this.reserve = reserve;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		//if the bid is under the reserve, trash it and return false
		if (offeredBid.getBidAmount() < reserve) {
			return false;
		}
		else {	
		    return super.placeBid(offeredBid); // this calls the placeBid method in the PARENT
		    // return placeBid(offeredBid); this is an infinite loop DONT DO THIS
		}
		
	}
	
	public void methodOnlyInReserve() {
		
	}

}
