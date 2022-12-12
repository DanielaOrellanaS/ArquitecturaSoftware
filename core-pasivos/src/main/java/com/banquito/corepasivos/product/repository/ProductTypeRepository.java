package com.banquito.corepasivos.product.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banquito.corepasivos.product.model.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, String> {

    List<ProductType> findByCodeProductType(String codeProductType);

    // Find all product types
    List<ProductType> findAll();

    // Delete product type by code
    void deleteByCodeProductType(String codeProductType);

    // find by contains name
    List<ProductType> findByNameContaining(String name);

    // find by name
    List<ProductType> findByName(String name);

    // find by type]
    List<ProductType> findByType(String type);



}
