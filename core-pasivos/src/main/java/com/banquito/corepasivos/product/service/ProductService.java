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
        List<Product> products = this.productRepository.findByPkCodeProduct(codeProduct);
        return products.isEmpty() ? null : products.get(0);
    }

    public List<Product> findByNameContaining(String name) {
        return this.productRepository.findByNameContaining(name);
    }

    public Product findByName(String name) {
        List<Product> product = this.productRepository.findByName(name);
        return product.isEmpty() ? null : product.get(0);
    }

    @Transactional
    public void createProduct(Product product) {
        List<Product> products = this.productRepository.findByName(product.getName());
        Optional<Product> productsPk = this.productRepository.findById(product.getPk());
        if (products.isEmpty() && productsPk.isEmpty())
            try {
                this.productRepository.save(product);
            } catch (Exception e) {
                throw new RuntimeException("There is already a product created with these parameters");
            }
        else
            throw new RuntimeException("There is already a product with this name or these codes");
    }

    @Transactional
    public void updateProduct(Product product) {
        Optional<Product> productPk = this.productRepository.findById(product.getPk());
        if (productPk.isEmpty())
            throw new RuntimeException("The code associated with the product was not found");
        else
            try {
                this.productRepository.save(product);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the product update");
            }
    }

    @Transactional
    public void deleteProduct(ProductPK pk) {
        Optional<Product> product = this.productRepository.findById(pk);
        if (product.isEmpty())
            throw new RuntimeException("The code associated with the product was not found");
        else
            try {
                this.productRepository.deleteById(pk);
            } catch (Exception e) {
                throw new RuntimeException("An error has occurred in the product delete");
            }
    }
    
}
