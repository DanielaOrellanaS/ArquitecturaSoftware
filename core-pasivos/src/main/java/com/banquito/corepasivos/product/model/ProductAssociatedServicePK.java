package com.banquito.corepasivos.product.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Data
@Embeddable
@NoArgsConstructor
public class ProductAssociatedServicePK implements Serializable {

    @Column(name = "code_associated_service", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "code_product", length = 32, nullable = false)
    private String codeProduct;

    @Column(name = "code_product_type", length = 32, nullable = false)
    private String codeProductType;
}
