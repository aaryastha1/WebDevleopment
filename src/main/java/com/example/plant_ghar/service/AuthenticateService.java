package com.example.plant_ghar.service;

import com.example.plant_ghar.dto.AuthenticateRequest;
import com.example.plant_ghar.dto.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
