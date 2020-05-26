package com.techelevator;

//has a buyout price that once met, the auction is over and no additional bids are accepted
public class BuyoutAuction extends Auction {
	
	private int buyoutPrice;

	public BuyoutAuction(String str,int buyoutPrice) {
		super(str);		
		this.buyoutPrice = buyoutPrice;
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		if (isOver) {
			return false;
		} 
		else {		
			
			//see if the buyout price has been met
			if (offeredBid.getBidAmount() >= buyoutPrice) {
			//   if it has, then mark the auction as over
				isOver = true;
			}
			//place the bid
			return super.placeBid(offeredBid);
		}
	
	}

}
 