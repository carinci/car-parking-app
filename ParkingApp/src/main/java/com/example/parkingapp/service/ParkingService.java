package com.example.parkingapp.service;

import com.example.parkingapp.model.Booking;
import com.example.parkingapp.model.ParkingSpot;
import org.springframework.stereotype.Service;
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

    }