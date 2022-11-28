package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import com.banquito.corepasivos.product.repository.ProductAssociatedServiceRepository;

@Service
public class ProductAssociatedServiceServiceImpl implements ProductAssociatedServiceService {

    @Autowired
    ProductAssociatedServiceRepository productAssociatedServiceRepository;

    @Override
    public List<ProductAssociatedService> getAllProductAssociatedServices() {
        return this.productAssociatedServiceRepository.findAll();
    }

}
