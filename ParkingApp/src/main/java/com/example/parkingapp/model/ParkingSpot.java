package com.example.parkingapp.model;

public class ParkingSpot {

    private Long id;
    private String location;
    private boolean isAvailable;
    private double rating; // Average rating for the parking spot
    private String feedback; // User feedback for the parking spot
    private Long favoriteCount; // Number of times marked as favorite

    // Constructor
    public ParkingSpot(Long id, String location, boolean isAvailable) {
        this.id = id;
        this.location = location;
        this.isAvailable = isAvailable;
        this.rating = 0.0;
        this.feedback = "";
        this.favoriteCount = 0L;
    }

    public ParkingSpot(long i, String location, boolean isAvailable, double v) {

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getFavoriteCount() {
        return favoriteCount;
    }

    public void incrementFavoriteCount() {
        this.favoriteCount++;
    }

    // Additional methods as necessary for parking spot management
}
