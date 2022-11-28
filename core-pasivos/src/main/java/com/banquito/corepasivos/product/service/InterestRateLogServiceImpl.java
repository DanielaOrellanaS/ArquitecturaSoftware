package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.InterestRateLog;
import com.banquito.corepasivos.product.repository.InterestRateLogRepository;

@Service
public class InterestRateLogServiceImpl implements InterestRateLogService{

    @Autowired
    InterestRateLogRepository interestRateLogRepository;

    @Override
    public List<InterestRateLog> getAllInterestRateLog(){
        return interestRateLogRepository.findAll();
    }
    
}
