package com.example.parkingapp.service;

public class SupportRequest {

    private String email;
    private String message;

    // Default Constructor
    public SupportRequest() {
    }

    // Constructor with parameters
    public SupportRequest(String email, String message) {
        this.email = email;
        this.message = message;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // toString method for logging and debugging
    @Override
    public String toString() {
        return "SupportRequest{" +
                "email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
