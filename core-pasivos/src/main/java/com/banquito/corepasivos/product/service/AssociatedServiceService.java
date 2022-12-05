package com.banquito.corepasivos.product.service;

import java.util.Optional;

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

    /* public AssociatedService findByCodeAssociatedService(String codeAssociatedService) {
        List<AssociatedService> services = this.associatedServiceRepository.findById(codeAssociatedService);
        return services.isEmpty() ? null : services.get(0);
    } */

    @Transactional
    public void saveAssociatedService(AssociatedService associatedService) {
        Optional<AssociatedService> service = this.associatedServiceRepository.findById(associatedService.getCodeAssociatedService());    
        if (service.isPresent()) {
            throw new RuntimeException("El servicio asociado ya existe");
        } else {
            associatedServiceRepository.save(associatedService);
        }
    }

}
