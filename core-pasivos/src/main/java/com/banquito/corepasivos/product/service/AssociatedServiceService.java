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

    public AssociatedService getAssociatedService(String codeAssociatedService) {
        return associatedServiceRepository.findById(codeAssociatedService).orElse(null);
    }

    @Transactional
    public AssociatedService saveAssociatedService(AssociatedService associatedService) {
        List<AssociatedService> service = this.associatedServiceRepository.findByCodeAssociatedService(associatedService.getCodeAssociatedService());
        if(service.isEmpty()){
            return associatedServiceRepository.save(associatedService);
        }else{
            throw new RuntimeException("El servicio asociado ya existe");
        }
        
    }
    
}
