package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.AssociatedService;

public interface AssociatedServiceRepository extends JpaRepository<AssociatedService, String>{
    List<AssociatedService> findByCodeAssociatedService(String codeAssociatedService);
    
}
