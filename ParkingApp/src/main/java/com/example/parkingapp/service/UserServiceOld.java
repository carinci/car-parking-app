package com.example.parkingapp.service;

import com.example.parkingapp.model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceOld {

    private final Map<String, User> users = new HashMap<>(); // Mock user storage

    public UserServiceOld() {
        // Pre-populate with a test user (for demonstration purposes)
        users.put("testuser", new User("testuser", "password", "test@example.com"));
    }

    public User registerUser(User user) {
        // Simulate user registration
        users.put(user.getUsername(), user);
        return user; // Return the registered user
    }

    public boolean validateUser(String username, String password) {
        // Simulate user validation
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public User getCurrentUser() {
        // Placeholder for getting the current user, normally from security context
        return users.get("testuser"); // Returning a mock user
    }

    public void updateUserProfile(User user) {
        // Simulate updating user profile
        users.put(user.getUsername(), user);
    }

    public void resetPassword(String username, String newPassword) {
        // Simulate password reset
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.setPassword(newPassword);
            users.put(username, user);
        }
    }

    public void submitUserFeedback(String username, String feedback) {
        // Simulate submitting user feedback
        // This should ideally interact with a feedback storage system
        System.out.println("Feedback from " + username + ": " + feedback);
    }

    public void updateUserPreferences(String username, String preferences) {
        // Simulate updating user preferences
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.setPreferences(preferences);
            users.put(username, user);
        }
    }

    public void logoutUser() {
    }

    // Additional methods can be added as required
}
