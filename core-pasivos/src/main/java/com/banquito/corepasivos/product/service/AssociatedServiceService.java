package com.banquito.corepasivos.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.AssociatedService;
import com.banquito.corepasivos.product.repository.AssociatedServiceRepository;

@Service
public class AssociatedServiceService {
    private final AssociatedServiceRepository associatedServiceRepository;

    public AssociatedServiceService(AssociatedServiceRepository associatedServiceRepository) {
        this.associatedServiceRepository = associatedServiceRepository;
    }

    public List<AssociatedService> findAllAssociatedService() {
        return associatedServiceRepository.findAll();
    }

    public List<AssociatedService> findByCodeAssociatedService(String codeAssociatedService) {
        return this.associatedServiceRepository.findByCodeAssociatedService(codeAssociatedService);
    }

    @Transactional
    public void saveAssociatedService(AssociatedService associatedService) {
        this.associatedServiceRepository.save(associatedService);

    }

    public AssociatedService findById(String codeAssociatedService) {
        return null;
    }

}
