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

    @PostMapping("/report-problem")
    public String reportProblem(@RequestParam Long spotId, @RequestParam String problem, RedirectAttributes redirectAttrs) {
        parkingService.reportProblem(spotId, problem);
        redirectAttrs.addFlashAttribute("message", "Problem reported for spot " + spotId);
        return "redirect:/dashboard";
    }

    @GetMapping("/bookSpot/{id}")
    public String bookSpot(@PathVariable("id") Long spotId, Model model) {
        ParkingSpot bookedSpot = parkingService.bookSpot(spotId);
        model.addAttribute("bookedSpot", bookedSpot);
        return "bookingConfirmation"; // Confirm booking view
    }

    @GetMapping("/cancelBooking/{id}")
    public String cancelBooking(@PathVariable("id") Long bookingId, Model model) {
        parkingService.cancelBooking(bookingId);
        return "redirect:/parking";
    }

    // Assuming getBookingHistory is a valid method in ParkingService
    @GetMapping("/booking-history")
    public String showBookingHistory(Model model) {
        List<Booking> bookingHistory = parkingService.getBookingHistory();
        model.addAttribute("bookingHistory", bookingHistory);
        return "bookingHistory"; // the name of your Thymeleaf template
    }





    @GetMapping("/reportProblem/{id}")
    public String reportProblemForm(@PathVariable("id") Long spotId, Model model) {
        model.addAttribute("spotId", spotId);
        return "reportProblem"; // Form to report a problem
    }

    @PostMapping("/reportProblem")
    public String submitReportProblem(@RequestParam String problemDescription, @RequestParam Long spotId) {
        parkingService.reportProblem(spotId, problemDescription);
        return "redirect:/parking";
    }

    // Assume saveFavoriteSpot is a valid method in ParkingService
    @GetMapping("/saveFavorite/{id}")
    public String saveFavoriteSpot(@PathVariable("id") Long userId, @PathVariable("id") Long spotId) {
        parkingService.saveFavoriteSpot(userId, spotId);
        return "redirect:/favorites"; // Redirect to a page showing favorites
    }

    // Assume shareParkingLocation is a valid method in ParkingService
    @GetMapping("/shareLocation/{id}")
    public String shareParkingLocation(@PathVariable("id") Long spotId, Model model) {
        String shareableLink = parkingService.shareParkingLocation(spotId);
        model.addAttribute("shareLink", shareableLink);
        return "shareLocation"; // View for sharing location
    }

    // Assume submitFeedback is a valid method in ParkingService
    @PostMapping("/feedback")
    public String submitFeedback(@RequestParam String feedback, @RequestParam Long spotId) {
        parkingService.submitFeedback(spotId, feedback);
        return "redirect:/feedbackReceived"; // Redirect after submitting feedback
    }
}
