package com.banquito.corepasivos.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

    List<Product> findByPkCodeProduct(String codeProduct);
    
    List<Product> findByPkCodeProductType(String codeProductType);

}
