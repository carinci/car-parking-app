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

    public ParkingService() {
        // Initialize with some mock parking spots
        for (long i = 1; i <= 10; i++) {
            parkingSpots.put(i, new ParkingSpot(i, "Location " + i, true, 0.0));
        }
    }

    public List<ParkingSpot> getAvailableSpots() {
        // Return a list of available parking spots
        List<ParkingSpot> availableSpots = new ArrayList<>();
        parkingSpots.forEach((id, spot) -> {
            if (spot.isAvailable()) {
                availableSpots.add(spot);
            }
        });
        return availableSpots;
    }

    public ParkingSpot bookSpot(Long spotId) {
        // Book a parking spot by ID
        ParkingSpot spot = parkingSpots.get(spotId);
        if (spot != null && spot.isAvailable()) {
            spot.setAvailable(false);
            parkingSpots.put(spotId, spot);
        }
        return spot;
    }

    public void cancelBooking(Long spotId) {
        // Cancel a booking
        ParkingSpot spot = parkingSpots.get(spotId);
        if (spot != null && !spot.isAvailable()) {
            spot.setAvailable(true);
            parkingSpots.put(spotId, spot);
        }
    }

    public void rateParkingSpot(Long spotId, double rating) {
        // Rate a parking spot
        ParkingSpot spot = parkingSpots.get(spotId);
        if (spot != null) {
            spot.setRating(rating);
            parkingSpots.put(spotId, spot);
        }
    }

    public void reportProblem(Long spotId, String problemDescription) {
        // Report a problem with a parking spot
        // Ideally, this should log the problem or notify an administrator
        System.out.println("Problem at spot " + spotId + ": " + problemDescription);
    }

    public void saveFavoriteSpot(Long userId, Long spotId) {
        // Save a parking spot as a favorite for a user
        // This method needs actual user and spot management in a real scenario
        System.out.println("User " + userId + " saved spot " + spotId + " as favorite");
    }

    public String getShareableLink(Long spotId) {
        // Generate a shareable link for a parking spot
        // In a real application, this should return a meaningful URL
        return "http://example.com/parking/" + spotId;
    }

    public String shareParkingLocation(Long spotId) {
        return null;
    }

    public void submitFeedback(Long spotId, String feedback) {
    }

    public ParkingSpot getParkingSpotDetails(Long spotId) {
        // Simulate fetching parking spot details
        return new ParkingSpot(spotId, "Location " + spotId, true, 0.0); // Return mock data
    }

    public List<Booking> getBookingHistory() {
        // Your logic to retrieve the booking history from the database
        return new ArrayList<>(); // Return an empty list or a list of bookings
    }

    public ParkingSpot addSpot(ParkingSpot spot) {
        return null;
    }
}
