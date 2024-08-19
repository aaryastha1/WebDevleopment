package com.example.plant_ghar.service.impl;

import com.example.plant_ghar.service.AuthenticateService;
import com.example.plant_ghar.Security.JwtService;
import com.example.plant_ghar.dto.AuthenticateRequest;
import com.example.plant_ghar.dto.AuthenticateResponse;
import com.example.plant_ghar.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepository userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getEmail(), authenticateRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) userRepo.getUserByUsername(authenticateRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticateResponse.builder().token(jwtToken).build();
    }
}
