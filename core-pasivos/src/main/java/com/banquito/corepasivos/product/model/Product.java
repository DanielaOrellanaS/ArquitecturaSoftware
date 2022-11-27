package com.banquito.corepasivos.product.model;

import java.math.BigDecimal;
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

@Data
@Entity
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private String codeProduct;

    @Column(name = "CODE_PRODUCT_TYPE", length = 32, nullable = false)
    private String productType;

    @Column(name = "CODE_SEGMENT", length = 16, nullable = true)
    private String segment;

    @Column(name = "CODE_INTEREST_RATE", length = 8, nullable = true)
    private String interestRate;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "END_DATE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "TEMPORALITY_ACCOUNT_STATE", length = 3, nullable = true)
    private String temporalityAccountState;

    @Column(name = "USE_CHECKBOOK", length = 1, nullable = true)
    private String useCheckbook;

    @Column(name = "ALLOW_TRANSFERENCES", length = 1, nullable = true)
    private String allowTransferences;

    @Column(name = "TYPE_CLIENT", length = 3, nullable = true)
    private String typeClient;

    @Column(name = "MIN_OPENING_BALANCE", scale = 17, precision = 2, nullable = false)
    private BigDecimal minOpeningBalance;

    public Product(String codeProduct) {
        this.codeProduct = codeProduct;
    }
}
