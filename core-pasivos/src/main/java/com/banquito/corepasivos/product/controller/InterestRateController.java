package com.banquito.corepasivos.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.InterestRate;
import com.banquito.corepasivos.product.service.InterestRateService;

@RestController
@RequestMapping("api/interest-rate")
public class InterestRateController {

    private final InterestRateService interestRateService;


    public InterestRateController(InterestRateService interestRateService) {
        this.interestRateService = interestRateService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRate>> findAllInterestRate() {
        List<InterestRate> interestRate = this.interestRateService
                .findAllInterestRates();
        return interestRate.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRate);
    }

    @RequestMapping(value = "/code/{codeInterestRate}", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRate>> findByCodeInterestRate(@PathVariable("codeInterestRate") String codeInterestRate) {
        List<InterestRate> interestRate = this.interestRateService
                .findAllInterestRateCode(codeInterestRate);
        return interestRate.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRate);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRate>> findByNameInterestRate(
            @PathVariable("name") String name) {
        List<InterestRate> interestRate = this.interestRateService
                .findByNameInterestRates(name);
        return interestRate.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRate);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createInterestRate(
            @RequestBody InterestRate interestRate) {
        try {
            this.interestRateService.createInterestRate(interestRate);
            return ResponseEntity.ok("Parameters of the interest rate created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateInterestrate(
            @RequestBody InterestRate interestRate) {
        try {
            this.interestRateService.updateInterestRate(interestRate);
            return ResponseEntity.ok("Parameters of the interest rate updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/{codeInterestRate}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteInterestRate(
            @PathVariable("codeInterestRate") String codeInterestRate){
        try {
            this.interestRateService.deleteInterestRate(codeInterestRate);
            return ResponseEntity.ok("Associated Service Parameters Removed Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
 
    
}
