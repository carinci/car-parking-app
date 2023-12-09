package com.example.parkingapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String feedback; // User feedback
    private double rating; // User rating for parking experience
    private String preferences; // User preferences


}

