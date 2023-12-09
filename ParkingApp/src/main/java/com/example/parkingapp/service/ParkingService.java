package com.example.parkingapp.service;

import com.example.parkingapp.model.Booking;
import com.example.parkingapp.model.ParkingSpot;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ParkingService {

    private final ConcurrentHashMap<Long, ParkingSpot> parkingSpots = new ConcurrentHashMap<>(); // Mock parking spot storage

    private long parkingSpotIncrement = 0;

    public ParkingSpot addSpot(ParkingSpot spot) {
        parkingSpotIncrement++;
        spot.setId(parkingSpotIncrement);
        parkingSpots.put(spot.getId(), spot);
        return spot;
    }

    public void deleteSpot(Long id) {
        parkingSpots.remove(id);
    }

    public void deleteSpot(ParkingSpot spot) {
        deleteSpot(spot.getId());
    }

    public void updateSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getId(), spot);
    }

    public ParkingSpot getSpot(Long id) {
        return parkingSpots.get(id);
    }

    public boolean hasSpot(Long id) {
        return parkingSpots.containsKey(id);
    }

    public List<ParkingSpot> getAllSpots() {
        return new ArrayList<>(parkingSpots.values());
    }

    public ParkingSpot getParkingSpotDetails(Long parkingSpotId) {
        return parkingSpots.get(parkingSpotId);
    }

    public boolean markAsFavorite(Long userId, Long parkingSpotId) {
        ParkingSpot spot = parkingSpots.get(parkingSpotId);
        if (spot != null) {
            // Logic to mark the spot as favorite for the user
            return true;
        }
        return false;
    }
    public boolean rateParkingSpot(Long parkingSpotId, double rating) {
        ParkingSpot spot = parkingSpots.get(parkingSpotId);
        if (spot != null) {
            // Logic to rate the parking spot
            // This could involve updating an average rating, etc.
            return true;
        }
        return false;
    }
    public boolean isParkingSpotAvailable(Long parkingSpotId, LocalDate date) {
        // Logic to check if a parking spot is available on a given date
        // This is a simplified version; real implementation might involve more detailed availability checks
        return true;
    }




}