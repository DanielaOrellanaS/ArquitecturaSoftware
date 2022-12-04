package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.ProductType;
import com.banquito.corepasivos.product.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public List<ProductType> readAllProductTypes() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType readByCodeProductType(String codeProductType) {
        return productTypeRepository.findByCodeProductType(codeProductType).get(0);
    }

    @Override
    public ProductType updateProductType(ProductType productType, String codeProductType) {
        ProductType productTypeToUpdate = productTypeRepository.findByCodeProductType(codeProductType).get(0);
        productTypeToUpdate.setCodeProductType(productType.findCodeProductType());
        productTypeToUpdate.setName(productType.findName());
        productTypeToUpdate.setType(productType.findType());
        productTypeToUpdate.setAllowEarnInterest(productType.findAllowEarnInterest());
        productTypeToUpdate.setAllowGeneralAccountState(productType.findAllowGeneralAccountState());
        productTypeToUpdate.setTemporalityInterest(productType.findTemporalityInterest());

        return productTypeRepository.save(productTypeToUpdate);
    }

    @Override
    public void deleteProductType(String codeProductType) {
        productTypeRepository.deleteByCodeProductType(codeProductType);
    }

}

