package com.banquito.corepasivos.product.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRODUCT")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CODE_PRODUCT", nullable = false, length = 32)
    private String codeProduct;

    @Column(name = "CODE_PRODUCT:TYPE", nullable = false, length = 32)
    private String codeProductType;

    @Column(name = "CODE_SEGMEN", nullable = true, length = 16)
    private String codeSegment;

    @Column(name = "CODE_INTEREST_RATE", nullable = false, length = 8)
    private String codeInterestrate;

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    @Column(name = "STATUS", nullable = false, length = 3)
    private String status;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "TEMPORALITY_ACCOUNT_STATE", nullable = true, length = 3)
    private String temporalityAccountState;

    @Column(name = "USE_CHECKBOOK", nullable = true, length = 1)
    private String useCheckbook;

    @Column(name = "ALLOW_TRANSFERENCES", nullable = true, length = 1)
    private String allowTransferences;

    @Column(name = "TYPE_CLIENT", nullable = true, length = 3)
    private String typeClient;

    @Column(name = "MIN_OPENING_BALANCE", nullable = false, scale = 17, precision = 2)
    private Double minOpeningBalance;

    public Product(String codeProduct) {
        this.codeProduct = codeProduct;
    }
}
