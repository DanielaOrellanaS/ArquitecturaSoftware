package com.banquito.corepasivos.product.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.corepasivos.product.model.InterestRateLog;
import com.banquito.corepasivos.product.service.InterestRateLogService;


@RestController
@RequestMapping("api/interest-rate-log")
public class InterestRateLogController {
    
    private final InterestRateLogService interestRateLogService;

    public InterestRateLogController(InterestRateLogService interestRateLogService) {
        this.interestRateLogService = interestRateLogService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRateLog>> findAllInterestRateLog() {
        List<InterestRateLog> interestRateLog = this.interestRateLogService
                .findAllInterestRatesLog();
        return interestRateLog.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRateLog);
    }

    @RequestMapping(value = "/codelog/{codeInterestRateLog}", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRateLog>> findByCodeInterestRateLog(@PathVariable("codeInterestRateLog") String codeInterestRateLog) {
        List<InterestRateLog> interestRateLog = this.interestRateLogService
                .findAllInterestRateLogCode(codeInterestRateLog);
        return interestRateLog.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRateLog);
    }

    @RequestMapping(value = "/codeInterest/{codeInterestRate}", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRateLog>> findByCodeInterestRate(
            @PathVariable("codeInterestRate") String codeInterestRate) {
        List<InterestRateLog> interestRateLog = this.interestRateLogService
                .findByInterestRateCode(codeInterestRate);
        return interestRateLog.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRateLog);
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRateLog>> findByStatus(
            @PathVariable("status") String status) {
        List<InterestRateLog> interestRateLog = this.interestRateLogService
                .findByStatusInterestRateLog(status);
        return interestRateLog.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRateLog);
    }

    @RequestMapping(value = "/date/{startdate}/{endDate}", method = RequestMethod.GET)
    public ResponseEntity<List<InterestRateLog>> findByNameInterestRate(
            @PathVariable("startdate") Date startdate,
            @PathVariable("endDate") Date endDate) {
        List<InterestRateLog> interestRateLog = this.interestRateLogService
                .findByDateInterestRateLog(startdate,endDate);
        return interestRateLog.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(interestRateLog);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createInterestRate(
            @RequestBody InterestRateLog interestRateLog) {
        try {
            this.interestRateLogService.createInterestRateLog(interestRateLog);
            return ResponseEntity.ok("Parameters of the interest rate created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<String> updateInterestRateLog(
            @RequestBody InterestRateLog interestRateLog) {
        try {
            this.interestRateLogService.updateInterestRateLog(interestRateLog);
            return ResponseEntity.ok("Parameters of the interest rate log updated successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.PUT)
    public ResponseEntity<String> deleteInterestRate(
            @PathVariable("codeInterestRate") String codeInterestRate){
        try {
            this.deleteInterestRate(codeInterestRate);
            return ResponseEntity.ok("Associated Service Parameters Removed Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
