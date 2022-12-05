package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.model.ProductPK;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductPK>{

    List<Product> findByPkCodeProduct(String codeProduct);
    
    List<Product> findByPkCodeProductType(String codeProductType);

    List<Product> findByNameContaining(String name);

    List<Product> findByName(String name);

}
