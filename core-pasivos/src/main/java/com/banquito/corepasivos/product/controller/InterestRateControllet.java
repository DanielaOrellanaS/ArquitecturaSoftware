package com.banquito.corepasivos.product.controller;


import com.banquito.corepasivos.product.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interestrate")
public class InterestRateControllet {

    @Autowired
    InterestRateService interestRateService;

    @GetMapping("/all")
    public Object getInterest() {
        return this.interestRateService.getAllInterestRates();
    }
}
