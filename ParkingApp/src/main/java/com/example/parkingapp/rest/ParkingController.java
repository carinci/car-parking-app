package com.example.parkingapp.rest;


import com.example.parkingapp.model.ParkingSpot;
import com.example.parkingapp.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingController {


    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/parking")
    public ResponseEntity<ParkingSpot> submitSpot(@RequestBody ParkingSpot spot) {
        // TODO some validation??
        spot = parkingService.addSpot(spot);
        return ResponseEntity.ok(spot);
    }

    @DeleteMapping("/parking")
    public ResponseEntity<ParkingSpot> deleteSpot(@RequestBody ParkingSpot spot) {
        parkingService.deleteSpot(spot);
        if (!parkingService.hasSpot(spot.getId()))
            return ResponseEntity.ok(spot); // if spot has been deleted successfully
        else
            return ResponseEntity.internalServerError().build(); // This is to catch any error or if the spot wasn't deleted.
    }

    @PatchMapping
    public ResponseEntity<ParkingSpot> updateSpot(@RequestBody ParkingSpot spot) {
        ParkingSpot currentSpot = parkingService.getSpot(spot.getId());

        if (currentSpot == null) return ResponseEntity.notFound().build(); // if spot doesn't exist cant update anything

        // Update any fields should they be set (per patch rules)

        if (spot.getSpotNumber() != null) currentSpot.setSpotNumber(spot.getSpotNumber());
        if (spot.getLocation() != null) currentSpot.setLocation(spot.getLocation());
        if (spot.getStatus() == false) currentSpot.setStatus(true);
        if (spot.getPrice() != null) currentSpot.setSpotPrice(spot.getSpotPrice());
        if (spot.getSpotDescription() != null) currentSpot.setSpotDescription(spot.getSpotDescription());
        if (spot.getSpotImage() != null) currentSpot.setSpotImage(spot.getSpotImage());

        parkingService.updateSpot(currentSpot);
        return ResponseEntity.ok(currentSpot);
    }
    }

