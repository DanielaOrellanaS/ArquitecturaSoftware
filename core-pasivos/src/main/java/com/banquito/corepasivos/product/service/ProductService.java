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

    public Optional<Product> findById(ProductPK pk) {
        return this.productRepository.findById(pk);
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
    public void updateProduct(ProductPK pk, Product product) {
        Optional<Product> products = this.productRepository.findById(pk);
        if (products.isEmpty())
            throw new RuntimeException("The code associated with the product was not found");
        else
            try {
                Product productToUpdate = products.get();
                productToUpdate.setName(product.getName());
                productToUpdate.setStatus(product.getStatus());
                productToUpdate.setStartDate(product.getStartDate());
                productToUpdate.setEndDate(product.getEndDate());
                productToUpdate.setTemporalityAccountState(product.getTemporalityAccountState());
                productToUpdate.setUseCheckbook(product.getUseCheckbook());
                productToUpdate.setAllowTransferences(product.getAllowTransferences());
                productToUpdate.setTypeClient(product.getTypeClient());
                productToUpdate.setMinOpeningBalance(product.getMinOpeningBalance());
                this.productRepository.save(productToUpdate);
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
