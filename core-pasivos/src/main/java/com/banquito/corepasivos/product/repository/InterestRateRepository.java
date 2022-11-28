package com.banquito.corepasivos.product.repository;

import com.banquito.corepasivos.product.model.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate, String>{

}
