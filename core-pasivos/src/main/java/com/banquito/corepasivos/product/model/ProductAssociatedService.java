package com.banquito.corepasivos.product.model;

import lombok.*;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "product_associated_service")
@Data
@NoArgsConstructor
public class ProductAssociatedService {

    @EmbeddedId
    private ProductAssociatedServicePK pk;

    @Column(name = "fee", scale = 17, precision = 2, nullable = false)
    private BigDecimal fee;

    @ManyToOne
    @JoinColumn(name = "code_associated_service", referencedColumnName = "code_associated_service", insertable = false, updatable = false, nullable = true)
    private AssociatedService associatedService;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "code_product", referencedColumnName = "code_product", insertable = false, updatable = false, nullable = true),
        @JoinColumn(name = "code_product_type", referencedColumnName = "code_product_type", insertable = false, updatable = false, nullable = true)
    })
    private Product product;

    public ProductAssociatedService(ProductAssociatedServicePK pk) {
        this.pk = pk;
    }
}
