package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.AssociatedService;
import com.banquito.corepasivos.product.repository.AssociatedServiceRepository;

@Service
public class AssociatedServiceServiceImpl implements AssociatedServiceService {

    @Autowired
    AssociatedServiceRepository associatedServiceRepository;

    @Override
    public List<AssociatedService> getAllAssociatedServices() {
        return this.associatedServiceRepository.findAll();
    }
}
