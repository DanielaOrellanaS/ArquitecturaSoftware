package com.banquito.corepasivos.product.service;

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
    public InterestRateLog deleteInterestRateLog(String codeInterestLog) {
        List<InterestRateLog> inetrestRate = this.interestRateLogRepository.findByCodeInterestLog(codeInterestLog);

        if (inetrestRate.isEmpty())
            throw new RuntimeException(
                    "Account with code-local-account: " + codeInterestLog + " not found.");

        InterestRateLog interestRateLog = inetrestRate.get(0);
        interestRateLog.setStatus("INA");

        return this.interestRateLogRepository.save(interestRateLog);
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
