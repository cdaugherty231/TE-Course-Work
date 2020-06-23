package com.techelevator.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.techelevator.models.Auction;

public class AuctionServiceTest {

    AuctionService auctionService;
    String testAllUrl = "http://dummy-mock-url.com";
    String testOneUrl = "http://dummy-mock-url.com/1";
    String testTitleUrl = "http://dummy-mock-url.com?title_like=Nothing";
    String testPriceUrl = "http://dummy-mock-url.com?currentBid_lte=23.23";

    RestTemplate mockRestTemplate = null;

    Auction[] auctions = {
            new Auction(0, "Zero", "Zero Auction", "User0", 0.0),
            new Auction(1, "One", "One Auction", "User1", 1.1)};

    Auction auction = new Auction(0, "Zero", "Zero Auction", "User0", 0.0);

    @Before
    public void setUp() {
        mockRestTemplate = Mockito.mock(RestTemplate.class);
        auctionService = new AuctionService(testAllUrl);
    }

    @After
    public void tearDown() {
        auctionService = null;
        mockRestTemplate = null;
    }

    @Test
    public void getAll() {
        when(mockRestTemplate.getForObject(
                Mockito.eq(testAllUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);

        auctionService.restTemplate = mockRestTemplate;
        assertArrayEquals(auctions, auctionService.getAll());
    }

    @Test
    public void getOne() {
        when(mockRestTemplate.getForObject(
                Mockito.eq(testOneUrl),
                Mockito.eq(Auction.class)))
                .thenReturn(auction);

        auctionService.restTemplate = mockRestTemplate;
        assertEquals(auction, auctionService.getOne(1));
    }

    @Test
    public void getByTitle() {
        when(mockRestTemplate.getForObject(
                Mockito.eq(testTitleUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);

        auctionService.restTemplate = mockRestTemplate;
        assertArrayEquals(auctions, auctionService.getByTitle("Nothing"));
    }
    
    @Test
    public void getByPrice() {
        when(mockRestTemplate.getForObject(
                Mockito.eq(testPriceUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);

        auctionService.restTemplate = mockRestTemplate;
        assertArrayEquals(auctions, auctionService.getByPrice(23.23));
    }

    @Test
    public void add() {
        String testAddString = "a,b,c,99.99";
        Auction fake = new Auction(3, "a", "b", "c", 99.99);
        // Need array length from getAll() - mocked with mock autions array
        when(mockRestTemplate.getForObject(
                Mockito.eq(testAllUrl),
                Mockito.eq(Auction[].class)))
                .thenReturn(auctions);
        when(mockRestTemplate.postForObject(
                Mockito.eq(testAllUrl),
                any(HttpEntity.class),
                Mockito.eq(Auction.class)))
                .thenReturn(fake);

        auctionService.restTemplate = mockRestTemplate;
        assertEquals("auctionService.add() should return a new auction",fake, auctionService.add(testAddString));
    }

    
    @Test
    public void update() {
        String testUpdateString = "9,q,w,e,11.11";
        Auction fake = new Auction(9, "q", "w", "e", 11.11);
        Mockito.doNothing().when(mockRestTemplate).put(
                Mockito.eq(testOneUrl),
                Mockito.eq(makeEntityHelper(fake)));

        auctionService.restTemplate = mockRestTemplate;
        Auction updatedAuction = auctionService.update(testUpdateString);
        assertNotNull("auctionService.update() should return the updated auction", updatedAuction);
        assertEquals("The updated auction does not match the expected result ",fake.toString(), updatedAuction.toString());
    }

    @Test
    public void delete() {
    	// No need for doNothing() since it is Mockito's default behavior for void methods.
        auctionService.restTemplate = mockRestTemplate;
        auctionService.delete(1);
        verify(mockRestTemplate).delete(testOneUrl);
    }


    private HttpEntity<Auction> makeEntityHelper(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(auction, headers);
        return entity;
    }


}
