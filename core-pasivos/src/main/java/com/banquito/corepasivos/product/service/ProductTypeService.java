package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.ProductType;

@Service
public interface ProductTypeService {

        ProductType createProductType(ProductType productType);

        List<ProductType> readAllProductTypes();

        ProductType readByCodeProductType(String codeProductType);

        ProductType updateProductType(ProductType productType, String codeProductType);

        void deleteProductType(String codeProductType);

}
