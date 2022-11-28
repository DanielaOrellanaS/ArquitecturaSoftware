package com.banquito.corepasivos.product.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class ProductPK implements Serializable {
    @Column(name = "code_product", length = 32, nullable = false)
    private String codeProduct;
    @Column(name = "code_product_type", length = 32, nullable = false)
    private String codeProductType;
}
