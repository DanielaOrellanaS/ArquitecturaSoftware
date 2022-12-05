package com.banquito.corepasivos.product.service;

import java.util.List;
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

    public List<AssociatedService> findAllAssociatedService() {
        return associatedServiceRepository.findAll();
    }

    public List<AssociatedService> findByCodeAssociatedService(String codeAssociatedService) {
        return this.associatedServiceRepository.findByCodeAssociatedService(codeAssociatedService);
    }

    @Transactional
    public void saveAssociatedService(AssociatedService associatedService) {
        try {
            List<AssociatedService> service = this.associatedServiceRepository
                    .findByName(associatedService.getName());
            if (service.isEmpty()){
                this.associatedServiceRepository.save(associatedService);
            }else{
                throw new RuntimeException("The associated service already exists");
            }
        } catch (Exception e) {
            throw new RuntimeException("The associated service already exists");
        }
    }

    public List<AssociatedService> findByNameContaining(String name) {
        return this.associatedServiceRepository.findByNameContaining(name);
    }

    @Transactional
    public void deleteAssociatedService(String codeAssociatedService) {
        Optional<AssociatedService> service = this.associatedServiceRepository.findById(codeAssociatedService);
        if (!service.isPresent())
            throw new RuntimeException("No associated services found");
        else
            try {
                this.associatedServiceRepository.deleteById(codeAssociatedService);
            } catch (Exception e) {
                throw new RuntimeException(
                        "An error occurred while removing one of the associated services");
            }
    }
    @Transactional
    public void updateAssociatedService(AssociatedService associatedService) {
        Optional<AssociatedService> service = this.associatedServiceRepository
                .findById(associatedService.getCodeAssociatedService());
        if (!service.isPresent())
            throw new RuntimeException("No associated services found");
        else
            try {
                this.associatedServiceRepository.save(associatedService);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the data update");
            }
    }

}
