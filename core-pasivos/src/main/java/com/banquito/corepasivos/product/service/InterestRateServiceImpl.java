package com.banquito.corepasivos.product.service;

import com.banquito.corepasivos.product.model.InterestRate;
import com.banquito.corepasivos.product.repository.InterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestRateServiceImpl implements InterestRateService{

    @Autowired
    InterestRateRepository interestRateRepository;

    @Override
    public List<InterestRate> getAllInterestRates(){
        return interestRateRepository.findAll();
    }
}
