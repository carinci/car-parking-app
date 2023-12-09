package com.example.parkingapp.service;

import com.example.parkingapp.model.Booking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    /**
     * This is designed to replicate the functionality of JPA without having a database for this app.
     */

    private int bookingIncrement = 0;

    private HashMap<Long, Booking> bookingMap = new HashMap<Long, Booking>();


    // insert booking into map
    public Booking addBooking(Booking booking) {
        bookingIncrement++;
        booking.setId(bookingIncrement);
        bookingMap.put(booking.getId(), booking);
        return booking;
    }


    // remove booking from map
    public void deleteBooking(Long id) {
        bookingMap.remove(id);
    }

    // remove booking from map
    public void deleteBooking(Booking booking) {
        deleteBooking(booking.getId());
    }

    // update booking in map
    public void updateBooking(Booking booking) {
        bookingMap.put(booking.getId(), booking);
    }

    // find booking in map
    public Booking getBooking(Long id) {
        return bookingMap.get(id);
    }

    // check if booking in the map
    public boolean hasBooking(Long id) {
        return bookingMap.containsKey(id);
    }

    public Booking bookParkingSpot(Long userId, Long parkingSpotId) {
        // Logic to book a parking spot
        // Create a new Booking object and add it to a booking map or list
        return new Booking(); // Return the booking object
    }

    public boolean cancelBooking(Long bookingId) {
        // Logic to cancel a booking
        // Remove the booking from the booking map or list
        return true; // Return true if successful
    }


    // retrieve all bookings
    public List<Booking> getAllBookings() {
        return bookingMap.values().stream().toList();
    }

    // retrieve all bookings by userid
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingMap.values().stream().filter(booking -> booking.getUserid() == userId).toList();
    }

    // retrieve all bookings by parking spot id
    public List<Booking> getBookingsByParkingSpotId(Long parkingSpotId) {
        return bookingMap.values().stream().filter(booking -> booking.getId() == parkingSpotId).toList();
    }

    // retrieve all bookings by parking spot id and userid
    public List<Booking> getBookingsByParkingSpotIdAndUserId(Long parkingSpotId, Long userId) {
        return bookingMap.values().stream().filter(booking -> booking.getId() == parkingSpotId && booking.getUserid() == userId).toList();
    }

}
