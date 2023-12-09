package com.example.parkingapp.router;

import com.example.parkingapp.model.Booking;
import com.example.parkingapp.model.ParkingSpot;
import com.example.parkingapp.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ParkingRouter {

    private final ParkingService parkingService;

    @Autowired
    public ParkingRouter(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/parking")
    public String showParking(Model model) {
        List<ParkingSpot> parkingSpots = parkingService.getAllSpots();
        model.addAttribute("parkingSpots", parkingSpots);
        return "parking";
    }

    @GetMapping("/parking/{id}")
    public String showParkingSpot(@PathVariable Long id, Model model) {
        ParkingSpot spot = parkingService.getSpot(id);
        model.addAttribute("spot", spot);
        return "parkingSpot";
    }

    @GetMapping("/parking/{id}/book")
    public String showBookingForm(@PathVariable Long id, Model model) {
        ParkingSpot spot = parkingService.getSpot(id);
        model.addAttribute("spot", spot);
        model.addAttribute("booking", new Booking());
        return "bookingForm";
    }

    @PostMapping("/parking/{id}/book")
    public String submitBooking(@PathVariable Long id, @ModelAttribute Booking booking, RedirectAttributes redirectAttributes) {
        ParkingSpot spot = parkingService.getSpot(id);
        booking.setParkingSpot(spot);
        redirectAttributes.addFlashAttribute("booking", booking);
        return "redirect:/parking/{id}/book/confirm";
    }

    @GetMapping("/parking/{id}/book/confirm")
    public String showBookingConfirmation(@PathVariable Long id, Model model) {
        ParkingSpot spot = parkingService.getSpot(id);
        model.addAttribute("spot", spot);
        return "bookingConfirmation";
    }


    }
