package com.example.parkingapp.router;

import com.example.parkingapp.service.SupportRequest;
import com.example.parkingapp.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/support")
public class SupportRouter {

    private final SupportService supportService;

    @Autowired
    public SupportRouter(SupportService supportService) {
        this.supportService = supportService;
    }

    @GetMapping
    public String showSupportForm(Model model) {
        // Add an empty SupportRequest object to the model to capture form data
        model.addAttribute("supportRequest", new SupportRequest());
        return "support";
    }

    @PostMapping
    public String submitSupportRequest(@ModelAttribute SupportRequest supportRequest) {
        // Pass the support request to the service layer for processing
        supportService.submitRequest(supportRequest);
        // Redirect to a confirmation page or back to the form with a success message
        return "redirect:/support/thank-you";
    }

    @GetMapping("/thank-you")
    public String showThankYou() {
        // Return a thank you page after a support request submission
        return "support-thank-you";
    }

    @GetMapping("/support")
    public String showSupportFormYes(Model model) {
        model.addAttribute("supportRequest", new SupportRequest());
        return "support";
    }

    @PostMapping("/support")
    public String submitSupportRequestYes(@ModelAttribute SupportRequest request) {
        supportService.createSupportRequest(request);
        return "redirect:/support?success";
    }
}
