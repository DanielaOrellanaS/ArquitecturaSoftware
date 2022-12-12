package com.banquito.corepasivos.product.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import com.banquito.corepasivos.product.model.ProductAssociatedServicePK;
import com.banquito.corepasivos.product.repository.ProductAssociatedServiceRepository;

@Service
public class ProductAssociatedServiceService {
    
    private final ProductAssociatedServiceRepository productAssociatedServiceRepository;

    public ProductAssociatedServiceService(ProductAssociatedServiceRepository productAssociatedServiceRepository) {
        this.productAssociatedServiceRepository = productAssociatedServiceRepository;
    }

    public List<ProductAssociatedService> findAllProductAssociatedServices() {
        return this.productAssociatedServiceRepository.findAll();
    }

    public Optional<ProductAssociatedService> findById(ProductAssociatedServicePK pk) {
        return this.productAssociatedServiceRepository.findById(pk);
    }

    @Transactional
    public void createProductAssociatedService(ProductAssociatedService productAssociatedService) {
        Optional<ProductAssociatedService> productAsociatedServices = 
        this.productAssociatedServiceRepository.findById(productAssociatedService.getPk());
        if (productAsociatedServices.isEmpty())
            try {
                this.productAssociatedServiceRepository.save(productAssociatedService);
            } catch (Exception e) {
                throw new RuntimeException("The product associated service could not be created");
            }
        else
            throw new RuntimeException("There is already a product associted service with these codes");
    }

    @Transactional
    public void updateProductAssociatedService(ProductAssociatedServicePK pk, ProductAssociatedService productAssociatedService) {
        Optional<ProductAssociatedService> productAssociatedServices = this.productAssociatedServiceRepository.findById(pk);
        if (productAssociatedServices.isEmpty())
            throw new RuntimeException("One of the product associated service codes was not found");
        else
            try {
                ProductAssociatedService productAssociatedServiceToUpdate = productAssociatedServices.get();
                productAssociatedServiceToUpdate.setFee(productAssociatedService.getFee());
                this.productAssociatedServiceRepository.save(productAssociatedServiceToUpdate);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the product associated service update");
            }
    }

    @Transactional
    public void deleteProductAssociatedService(ProductAssociatedServicePK pk) {
        Optional<ProductAssociatedService> productAssociatedServices = this.productAssociatedServiceRepository.findById(pk);
        if (productAssociatedServices.isEmpty())
            throw new RuntimeException("The product associated service does not exist");
        else
            try {
                this.productAssociatedServiceRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the product associated service delete");
            }
    }

}
