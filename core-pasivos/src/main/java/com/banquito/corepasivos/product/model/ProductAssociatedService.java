package com.banquito.corepasivos.product.model;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name="PRODUCT_ASSOCIATED_SERVICE")
public class ProductAssociatedService {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private ProductAssociatedServicePK pk;

    @Column(name="FEE", scale=17, precision=2, nullable=false)
    private BigDecimal fee;

    public ProductAssociatedService(ProductAssociatedServicePK pk) {
        this.pk = pk;
    }
}
