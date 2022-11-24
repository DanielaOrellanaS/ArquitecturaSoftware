package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductAssociatedServicePK {
    
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private String codeProduct;

    public ProductAssociatedServicePK(String codeAssociatedService, String codeProduct) {
        this.codeAssociatedService = codeAssociatedService;
        this.codeProduct = codeProduct;
    }

    
}
