package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT_ASSOCIATED_SERVICE_PARAM")
public class ProductAssociatedService {
    @EmbeddedId
    private ProductAssociatedService pk;

    @Column(name = "FEE", nullable = false, scale = 17, precision = 2)
    private Double fee;

}
