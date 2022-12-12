package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_type")
@Data
@NoArgsConstructor
public class ProductType {

    @Id
    @Column(name = "code_product_type", length = 32, nullable = false)
    private String codeProductType;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "type", length = 3, nullable = false)
    private String type;

    @Column(name = "allow_earn_interest", length = 1, nullable = false)
    private String allowEarnInterest;

    @Column(name = "allow_gen_acc_state", length = 1, nullable = false)
    private String allowGeneralAccountState;

    @Column(name = "temporality_interest", length = 3, nullable = true)
    private String temporalityInterest;

    public ProductType(String codeProductType) {
        this.codeProductType = codeProductType;
    }

}
