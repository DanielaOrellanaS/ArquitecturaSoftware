package com.banquito.corepasivos.product.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.InterestRate;
import com.banquito.corepasivos.product.repository.InterestRateRepository;

@Service
public class InterestRateService {

    private final InterestRateRepository interestRateRepository;

    

    public InterestRateService(InterestRateRepository interestRateRepository) {
        this.interestRateRepository = interestRateRepository;
    }

    public List<InterestRate> findAllInterestRates() {
        return interestRateRepository.findAll();
    }

    public List<InterestRate> findAllInterestRateCode(String codeInterestRate) {
        return interestRateRepository.findByCodeInterestRate(codeInterestRate);
    }

  

    public List<InterestRate> findByNameInterestRates(String name) {
        return this.interestRateRepository.findByNameContaining(name);
    }

    @Transactional
    public void createInterestRate(InterestRate interestRate) {
        try {
            List<InterestRate> interest = this.interestRateRepository
                    .findByNameContaining(interestRate.getName());
            if(interest.isEmpty()){
                this.interestRateRepository.save(interestRate);
            }else{
                throw new RuntimeException("Cannot create an interest with the same name");
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Cannot create an interest with the same name");
        }
    }

    @Transactional
    public void deleteInterestRate(String codeInterestRate) {
        
            try {
                this.interestRateRepository.deleteById(codeInterestRate);
            } catch (Exception e) {
                throw new RuntimeException(
                        "An error occurred while removing one inetereste rate");
            }
    }
    @Transactional
    public void updateInterestRate(InterestRate interestRate) {
        Optional<InterestRate> interest = this.interestRateRepository
                .findById(interestRate.getCodeInterestRate());
        if (!interest.isPresent())
            throw new RuntimeException("Interest rate not found");
        else
            try {
                this.interestRateRepository.save(interestRate);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the data update");
            }
    }
    
}
