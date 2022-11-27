package com.banquito.corepasivos.product.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Embeddable
public class ProductAssociatedServicePK implements Serializable {
    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private String codeProduct;

    @Column(name = "CODE_PRODUCT_TYPE", length = 32, nullable = false)
    private String codeProductType;
}
