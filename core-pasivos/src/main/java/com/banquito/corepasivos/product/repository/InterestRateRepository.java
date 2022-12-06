package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.InterestRate;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate, String> {


    List<InterestRate> findByCodeInterestRate(String codeInterestRate);

    List<InterestRate> findByNameContaining(String name);
    
}
