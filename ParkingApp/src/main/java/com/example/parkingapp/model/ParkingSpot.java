package com.example.parkingapp.model;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {

    private Long id;
    private String location;
    private boolean isAvailable;
    private double rating; // Average rating for the parking spot
    private String feedback; // User feedback for the parking spot
    private Long favoriteCount; // Number of times marked as favorite
    private Long bookedCount; // Number of times booked
    private Long userId; // User ID of the user who owns the parking spot
    private boolean spotNumber; // Spot number of the parking spot

}