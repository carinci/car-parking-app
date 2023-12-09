package com.example.parkingapp.rest;

import com.example.parkingapp.model.ParkingSpot;
import com.example.parkingapp.model.User;
import com.example.parkingapp.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> submitUser(@RequestBody User user) {
        // TODO some validation??
        user = userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user")
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        if (!userService.hasUser(user.getId()))
            return ResponseEntity.ok(user); // if user has been deleted successfully
        else
            return ResponseEntity.internalServerError().build(); // This is to catch any error or if the user wasn't deleted.
    }

    @PatchMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User currentUser = userService.getUser(user.getId());

        if (currentUser == null) return ResponseEntity.notFound().build(); // if user doesn't exist cant update anything

        // Update any fields should they be set (per patch rules)

        if (user.getUsername() != null) currentUser.setUsername(user.getUsername());
        if (user.getPassword() != null) currentUser.setPassword(user.getPassword());
        if (user.getEmail() != null) currentUser.setEmail(user.getEmail());
        if (user.getFeedback() != null) currentUser.setFeedback(user.getFeedback());
        if (user.getPreferences() != null)  currentUser.setPreferences(user.getPreferences());

        userService.updateUser(currentUser);
        return ResponseEntity.ok(currentUser);
    }


}
