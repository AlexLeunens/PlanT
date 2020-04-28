package com.fjord.plant.Services;

import com.fjord.plant.Model.ConfirmationToken;
import com.fjord.plant.Repository.ConfirmationTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public ConfirmationToken save(ConfirmationToken token) {

        return confirmationTokenRepository.save(token);
    }

    public ConfirmationToken findByConfirmationToken(String token) {

        return confirmationTokenRepository.findByConfirmationToken(token);
    }
}