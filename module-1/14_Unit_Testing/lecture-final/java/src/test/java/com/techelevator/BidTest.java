package com.techelevator;

import org.junit.Test;

import junit.framework.Assert;

public class BidTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void create_new_bid_sets_bidder_correctly() {
		
		//Arrange, Act
		Bid b = new Bid("Katie",1);
		//Act
		//Assert
		Assert.assertEquals("Katie", b.getBidder());
	}
	
	@Test
	public void create_new_bid_sets_bid_amount_correctly() {
		
		//Arrange, Act
		Bid b = new Bid("Katie",1);
		//Act
		//Assert
		Assert.assertEquals(1,b.getBidAmount());
	}
	
	@Test
	public void no_negative_bids_allowed_make_bid_amount_zero() {
		//Arrange, Act
		Bid b = new Bid("Katie",-1);
		//Act
		//Assert
		Assert.assertEquals(0,b.getBidAmount());
	}


}
