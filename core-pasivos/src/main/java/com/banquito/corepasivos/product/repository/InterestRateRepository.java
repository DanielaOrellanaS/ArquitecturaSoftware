package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.InterestRate;

public interface InterestRateRepository extends JpaRepository<InterestRate, String> {
    List<InterestRate> findByCodeInterestRate(String codeInterestRate);
    
}
