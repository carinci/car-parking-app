package com.example.parkingapp.service;

import com.example.parkingapp.model.Booking;
import com.example.parkingapp.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    /**
     * This is designed to replicate the functionality of JPA without having a database for this app.
     */

    private long userIncrement = 0;

    private HashMap<Long, User> userMap = new HashMap<Long, User>();


    // insert booking into map
    public User addUser(User booking) {
        userIncrement++;
        booking.setId(userIncrement);
        userMap.put(booking.getId(), booking);
        return booking;
    }


    // remove booking from map
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    // remove booking from map
    public void deleteUser(User booking) {
        deleteUser(booking.getId());
    }

    // update booking in map
    public void updateUser(User booking) {
        userMap.put(booking.getId(), booking);
    }

    // find booking in map
    public User getUser(Long id) {
        return userMap.get(id);
    }

    // check if booking in the map
    public boolean hasUser(Long id) {
        return userMap.containsKey(id);
    }

    // retrieve all bookings
    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }
}
