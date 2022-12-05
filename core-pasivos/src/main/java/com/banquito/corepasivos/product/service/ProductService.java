package com.banquito.corepasivos.product.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.model.ProductPK;
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
        try {
            this.productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("There is already a product created with these parameters");
        }
    }

    @Transactional
    public void updateProduct(Product product) {
        Optional<Product> productPk = this.productRepository.findById(product.getPk());
        if (productPk.isPresent())
            try {
                this.productRepository.save(product);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the product update");
            }
        else
            throw new RuntimeException("The code associated with the product was not found");
    }

    @Transactional
    public void deleteProduct(ProductPK pk) {
        Optional<Product> product = this.productRepository.findById(pk);
        if (product.isPresent())
            try {
                this.productRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the product delete");
            }
        else
            throw new RuntimeException("The code associated with the product was not found");
    }
    
}
