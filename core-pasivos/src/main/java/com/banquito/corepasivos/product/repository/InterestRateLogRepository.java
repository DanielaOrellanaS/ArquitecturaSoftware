package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.InterestRateLog;

public interface InterestRateLogRepository extends JpaRepository<InterestRateLog, String>{
    List<InterestRateLog> findByCodeInterestRateLog(String codeInterestRateLog);
    
}
