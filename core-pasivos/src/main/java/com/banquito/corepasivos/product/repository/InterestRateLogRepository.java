package com.banquito.corepasivos.product.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.InterestRateLog;

@Repository
public interface InterestRateLogRepository extends JpaRepository<InterestRateLog, String>{

    List<InterestRateLog> findByCodeInterestLog(String codeInterestLog);

    List<InterestRateLog> findByCodeInterestRate(String codeInterestRate);
    
    List<InterestRateLog> findByStatus(String status);

    List<InterestRateLog> findByStartDateBetween(Date startDate, Date endDate);
}
