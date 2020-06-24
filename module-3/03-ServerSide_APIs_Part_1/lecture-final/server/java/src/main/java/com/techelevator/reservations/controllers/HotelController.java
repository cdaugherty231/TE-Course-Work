package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }
    
    @RequestMapping(path="/reservations",method=RequestMethod.GET)
    public List<Reservation> listReservations() {
    	return reservationDAO.findAll();
    }
    
    //Get a reservation by its id: path /reservations/5
    @RequestMapping(path = "/reservations/{whatever}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int whatever) {
        return reservationDAO.get(whatever);
    }
    
    //List all reservations by a hotel; path /hotels/5/reservations GET
    @RequestMapping(path = "/hotels/{id}/reservations",method = RequestMethod.GET)
    public List<Reservation> getReservationByHotelId(@PathVariable ("id") int hotelId){
    	return reservationDAO.findByHotel(hotelId);
    }
    
    //Create a new reservation
    //path /hotels/5/reservations POST 
    @RequestMapping(path = "/hotels/{id}/reservations",method = RequestMethod.POST)
    public Reservation addReservation (@RequestBody Reservation reservation, @PathVariable int id) {
    	return reservationDAO.create(reservation, id);
    }
    
    //Filter hotels by city and state
    @RequestMapping(path="/hotels/filter",method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam (required=false) String state, @RequestParam (required=false) String city){
    	return hotelDAO.filterByStateAndCity(state, city);
    	
    }
}
