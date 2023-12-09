package com.example.parkingapp.service;

public class ProblemReport {

    private String description;
    private String email;
    private String name;
    private String phone;
    private String subject;

    public ProblemReport() {
    }

    public ProblemReport(String description, String email, String name, String phone, String subject) {
        this.description = description;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSubject()
    {
        return subject;
    }
}
