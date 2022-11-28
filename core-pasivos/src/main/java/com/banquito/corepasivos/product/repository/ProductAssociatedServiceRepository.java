package com.banquito.corepasivos.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import com.banquito.corepasivos.product.model.ProductAssociatedServicePK;

@Repository
public interface ProductAssociatedServiceRepository
        extends JpaRepository<ProductAssociatedService, ProductAssociatedServicePK> {

}
