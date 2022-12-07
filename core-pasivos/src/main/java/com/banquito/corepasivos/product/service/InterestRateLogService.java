package com.banquito.corepasivos.product.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.InterestRateLog;
import com.banquito.corepasivos.product.repository.InterestRateLogRepository;
import com.banquito.corepasivos.product.repository.InterestRateRepository;

@Service
public class InterestRateLogService {

    private final InterestRateLogRepository interestRateLogRepository;
    private final InterestRateRepository interestrateRepository;

    public InterestRateLogService(InterestRateLogRepository interestRateLogRepository,
            InterestRateRepository interestrateRepository) {
        this.interestRateLogRepository = interestRateLogRepository;
        this.interestrateRepository = interestrateRepository;
    }

    public List<InterestRateLog> findAllInterestRatesLog() {
        return interestRateLogRepository.findAll();
    }

    public List<InterestRateLog> findAllInterestRateLogCode(String codeInterestLog) {
        return interestRateLogRepository.findByCodeInterestLog(codeInterestLog);
    }

    public List<InterestRateLog> findByInterestRateCode(String codeInterest) {
        return interestRateLogRepository.findByCodeInterestRate(codeInterest);
    }

    public List<InterestRateLog> findByStatusInterestRateLog(String status) {
        return interestRateLogRepository.findByStatus(status);
    }

    public List<InterestRateLog> findByDateInterestRateLog(Date startDate, Date endDate) {
        return this.interestRateLogRepository.findByStartDateBetween(startDate, endDate);
    }

    @Transactional
    public void createInterestRateLog(InterestRateLog interestRateLog) {
        try {
            if (!interestrateRepository.existsByCodeInterestRate(interestRateLog.getCodeInterestRate()))
                throw new RuntimeException("The code of interest rate dont exist");

            this.interestRateLogRepository.save(interestRateLog);
        } catch (Exception e) {
            throw new RuntimeException("The interest could not be created, parameters failed.");
        }
    }

    @Transactional
    public void deleteInterestRateLog(InterestRateLog interestRateLog) {
        Optional<InterestRateLog> interest = this.interestRateLogRepository
                .findById(interestRateLog.getCodeInterestLog());

        interestRateLog.setStatus("INA");
        try {
            if (interest.isEmpty()) {
                throw new RuntimeException(
                        "An error occurred while change status on inetereste rate log");
            } else {
                this.interestRateLogRepository.save(interestRateLog);
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    "An error occurred while removing one inetereste rate log");
        }
    }

    @Transactional
    public void updateInterestRateLog(InterestRateLog interestRateLog) {
        Optional<InterestRateLog> interest = this.interestRateLogRepository
                .findById(interestRateLog.getCodeInterestLog());
        if (!interest.isPresent())
            throw new RuntimeException("Log of interest rate not found");
        else
            try {
                this.interestRateLogRepository.save(interestRateLog);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the data update");
            }
    }

}
