package com.banquito.corepasivos.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.InterestRateLog;


@Repository
public interface InterestRateLogRepository extends JpaRepository<InterestRateLog,String>{
    
}
