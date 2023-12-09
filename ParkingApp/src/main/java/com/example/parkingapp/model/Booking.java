package com.example.parkingapp.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private long id;
    private ParkingSpot spot;
    private Long userid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public void setParkingSpot(ParkingSpot spot) {
        this.spot = spot;

    }
}
