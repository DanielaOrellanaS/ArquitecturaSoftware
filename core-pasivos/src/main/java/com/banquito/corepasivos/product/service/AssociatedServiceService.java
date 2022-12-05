package com.banquito.corepasivos.product.service;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.AssociatedService;
import com.banquito.corepasivos.product.repository.AssociatedServiceRepository;

@Service
public class AssociatedServiceService {
    private final AssociatedServiceRepository associatedServiceRepository;

    public AssociatedServiceService(AssociatedServiceRepository associatedServiceRepository) {
        this.associatedServiceRepository = associatedServiceRepository;
    }

    public AssociatedService getAssociatedService(String codeAssociatedService) {
        return associatedServiceRepository.findById(codeAssociatedService).orElse(null);
    }
    
}
