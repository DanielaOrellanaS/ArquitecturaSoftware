package com.banquito.corepasivos.product.service;

import java.util.List;

import com.banquito.corepasivos.product.model.Product;
import com.banquito.corepasivos.product.model.ProductPK;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> readAllProducts();

    List<Product> readByCodeProductType(String codeProductType);

    Product readByCodeProduct(String codeProduct);

    Product updateProduct(Product product, ProductPK productPK);

    void deleteProduct(ProductPK productPK);

}
