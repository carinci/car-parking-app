package com.example.parkingapp.rest;


import com.example.parkingapp.model.ParkingSpot;
import com.example.parkingapp.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingController {


    private final ParkingService parkingService;;

    public ParkingController(ParkingService bookingRepository) {
        this.parkingService = bookingRepository;
    }



    /**
     * This endpoint is used to log system events.
     *
     * @param systemEvent - Message to be logged to system.
     * @return 200 - OK if the message was logged successfully.
     */
    @PostMapping("/system-log")
    public ResponseEntity<?> logSystemEvent(@RequestBody String systemEvent) {
        System.out.println(systemEvent); // TODO potentially move this to a log file.
        return ResponseEntity.ok().build();
    }

    @PostMapping("/parking")
    public ResponseEntity<ParkingSpot> submitSpot(@RequestBody ParkingSpot spot) {
        spot = parkingService.addSpot(spot);
        return ResponseEntity.ok(spot);
    }

    @DeleteMapping("/parking")
    public ResponseEntity<ParkingSpot> deleteSpot(@RequestBody ParkingSpot spot) {
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/parking")
    public ResponseEntity<ParkingSpot> updateSpot(@RequestBody ParkingSpot spot) {
        return ResponseEntity.badRequest().build();
    }




}
