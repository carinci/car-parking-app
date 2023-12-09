package com.example.parkingapp.rest;


import com.example.parkingapp.model.Booking;
import com.example.parkingapp.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {


    private final BookingService bookingRepository;;

    public BookingController(BookingService bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @PostMapping("/booking")
    public ResponseEntity<Booking> submitBooking(@RequestBody Booking booking) {
        // TODO some validation??
        booking = bookingRepository.addBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/booking")
    public ResponseEntity<Booking> deleteBooking(@RequestBody Booking booking) {
        bookingRepository.deleteBooking(booking);
        if (!bookingRepository.hasBooking(booking.getId()))
            return ResponseEntity.ok(booking); // if booking has been deleted successfully
        else
            return ResponseEntity.internalServerError().build(); // This is to catch any error or if the booking wasn't deleted.
    }

    @PatchMapping("/booking")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {

        Booking currentBooking = bookingRepository.getBooking(booking.getId());

        if (currentBooking == null) return ResponseEntity.notFound().build(); // if booking doesn't exist cant update anything

        // Update any fields should they be set (per patch rules)
        if (booking.getEndTime() != null) currentBooking.setEndTime(booking.getEndTime());
        if (booking.getStartTime() != null) currentBooking.setStartTime(booking.getStartTime());
        if (booking.getSpot() != null) currentBooking.setSpot(booking.getSpot());
        if (booking.getUserid() != null) currentBooking.setUserid(booking.getUserid());

        bookingRepository.updateBooking(currentBooking);
        return ResponseEntity.ok(currentBooking);
    }



}
