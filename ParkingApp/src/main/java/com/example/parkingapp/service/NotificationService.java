package com.example.parkingapp.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    // This method simulates the update of notification preferences.
    public void updateNotificationPreferences(Long userId, String preferences) {
        // In a real application, you would update the user's notification preferences in the database.
        // The 'preferences' parameter could be a String representing notification preferences.
        // For the simulation, we'll assume the preferences are updated successfully.
        System.out.println("Notification preferences updated for user ID " + userId + ": " + preferences);
    }
}
