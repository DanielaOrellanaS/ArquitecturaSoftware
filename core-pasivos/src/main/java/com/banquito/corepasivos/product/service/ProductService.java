package com.banquito.corepasivos.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    public List<Product> findByCodeProductType(String codeProductType) {
        return this.productRepository.findByPkCodeProductType(codeProductType);
    }

    public Product findByCodeProduct(String codeProduct) {
        List<Product> product = this.productRepository.findByPkCodeProduct(codeProduct);
        return product.isEmpty() ? null : product.get(0);
    }

    public Product findByName(String name) {
        List<Product> product = this.productRepository.findByName(name);
        return product.isEmpty() ? null : product.get(0);
    }

    @Transactional
    public void createProduct(Product product) {
        List<Product> products = this.productRepository.findByName(product.getName());
        if (products.isEmpty()) {
            this.productRepository.save(product);
        } else {
            throw new RuntimeException("The product already exists");
        }
    }
    
}
