package com.banquito.corepasivos.product.service;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.ProductType;
import com.banquito.corepasivos.product.repository.ProductTypeRepository;

@Service
public class ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductType> findAllProductTypes() {
        return this.productTypeRepository.findAll();
    }

    public ProductType findByCodeProductType(String codeProductType) {
        List<ProductType> productType = this.productTypeRepository.findByCodeProductType(codeProductType);
        return productType.isEmpty() ? null : productType.get(0);
    }

    public ProductType findByName(String name) {
        List<ProductType> productType = this.productTypeRepository.findByName(name);
        return productType.isEmpty() ? null : productType.get(0);
    }


    @Transactional
    public String createProductType(ProductType productType) {

        Console console = System.console();
        console.printf("productType: " + productType);
        List<ProductType> productTypes = this.productTypeRepository.findByName(productType.getName());
        // print(productTypes);
        

        if (productTypes.isEmpty()) {
            this.productTypeRepository.save(productType);
            return "The product type was created successfully";
        } else {
            return "The product type already exists";
        }
    }

    @Transactional
    public void deleteProductType(String codeProductType) {
        Optional<ProductType> product = this.productTypeRepository.findById(codeProductType);
        if (!product.isPresent())
            throw new RuntimeException("No associated services found");
        else
            try {
                this.productTypeRepository.deleteById(codeProductType);
            } catch (Exception e) {
                throw new RuntimeException(
                        "An error occurred while removing one of the associated services");
            }
    }

    public List<ProductType> findByNameContaining(String name) {
        return this.productTypeRepository.findByNameContaining(name);
    }

    @Transactional
    public void updateProductType(ProductType productType) {
        Optional<ProductType> service = this.productTypeRepository
                .findById(productType.getCodeProductType());
        if (!service.isPresent())
            throw new RuntimeException("No associated services found");
        else
            try {
                this.productTypeRepository.save(productType);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the data update");
            }
    }
    
}
