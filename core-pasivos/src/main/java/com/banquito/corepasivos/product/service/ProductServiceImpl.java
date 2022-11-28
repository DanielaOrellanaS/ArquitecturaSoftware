package com.banquito.corepasivos.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.model.ProductPK;
import com.banquito.corepasivos.product.repository.ProductRepository;

@Repository
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> readAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product readByCodeProduct(String codeProduct) {
        return this.productRepository.findByPkCodeProduct(codeProduct).get(0);
    }

    @Override
    public List<Product> readByCodeProductType(String codeProductType) {
        return this.productRepository.findByPkCodeProductType(codeProductType);
    }

    @Override
    public Product updateProduct(Product product, ProductPK productPK) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteProduct(ProductPK productPK) {
        // TODO Auto-generated method stub
        
    }
    
}
