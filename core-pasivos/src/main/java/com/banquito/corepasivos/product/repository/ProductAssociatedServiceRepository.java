package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import com.banquito.corepasivos.product.model.ProductAssociatedServicePK;

public interface ProductAssociatedServiceRepository
        extends JpaRepository<ProductAssociatedService, ProductAssociatedServicePK> {
    List<ProductAssociatedService> findByPkCodeAssociatedService(String codeAssociatedService);

    List<ProductAssociatedService> findByPkCodeProduct(String codeProduct);

    List<ProductAssociatedService> findByPkCodeProductType(String codeProductType);
}
