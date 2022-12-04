package com.banquito.corepasivos.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.service.InterestRateLogService;

@RestController
@RequestMapping("/interesratelog")
public class InterestRateLogController {

    @Autowired
    InterestRateLogService interestRateLogService;

    @GetMapping("/all")
    public Object findInterestRateLog(){
        return this.interestRateLogService.findAllInterestRateLog();
    }
    
}
