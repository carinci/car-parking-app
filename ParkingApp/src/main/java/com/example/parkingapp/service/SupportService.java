package com.example.parkingapp.service;

import com.example.parkingapp.service.SupportRequest;
import org.springframework.stereotype.Service;
// Import any additional packages needed

@Service
public class SupportService {



    public void submitRequest(SupportRequest supportRequest) {

        System.out.println("Support request submitted: " + supportRequest);
    }

    public void createSupportRequest(SupportRequest request) {
        // Logic to save the support request
    }
}
