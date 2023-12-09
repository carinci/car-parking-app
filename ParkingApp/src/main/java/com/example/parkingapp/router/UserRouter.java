package com.example.parkingapp.router;

import com.example.parkingapp.model.User;
import com.example.parkingapp.service.UserServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRouter {

    private final UserServiceOld userService;

    @Autowired
    public UserRouter(UserServiceOld userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.validateUser(username, password)) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute User user) {
        userService.updateUserProfile(user);
        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/login";
    }

    @GetMapping("/submitFeedback")
    public String feedbackForm() {
        return "feedbackForm"; // Thymeleaf template for feedback form
    }

    @PostMapping("/submitFeedback")
    public String submitFeedback(@RequestParam String feedback) {
        User currentUser = userService.getCurrentUser();
        userService.submitUserFeedback(currentUser.getUsername(), feedback);
        return "redirect:/dashboard";
    }

    @GetMapping("/updatePreferences")
    public String preferencesForm() {
        return "preferencesForm"; // Thymeleaf template for preferences form
    }

    @PostMapping("/updatePreferences")
    public String updatePreferences(@RequestParam String preferences) {
        User currentUser = userService.getCurrentUser();
        userService.updateUserPreferences(currentUser.getUsername(), preferences);
        return "redirect:/dashboard";
    }

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang, RedirectAttributes redirectAttrs) {
        // Simulate changing language
        redirectAttrs.addFlashAttribute("message", "Language changed to " + lang);
        return "redirect:/dashboard";
    }

    @PostMapping("/update-account")
    public String updateAccount(@ModelAttribute User user, RedirectAttributes redirectAttrs) {
        // Simulate updating account information
        redirectAttrs.addFlashAttribute("message", "Account updated for " + user.getUsername());
        return "redirect:/profile";
    }
}
