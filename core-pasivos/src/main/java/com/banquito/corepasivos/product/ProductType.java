package com.banquito.corepasivos.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TYPE")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductType {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_PRODUCT_TYPE", length = 32, nullable = false)
    private String codeProductType;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;
    @Column(name = "ALLOW_EARN_INTEREST", length = 1, nullable = false)
    private String allowEarnInterest;
    @Column(name = "ALLOW_GEN_ACC_STATE", length = 1, nullable = false)
    private String allowGeneralAccountState;
    @Column(name = "TEMPORALITY_INTEREST", length = 3, nullable = true )
    private String temporalityInterest;

    public ProductType(String codeProductType){
        this.codeProductType=codeProductType;
    }

}
