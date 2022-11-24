package com.banquito.corepasivos.product.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "CODE_PRODUCT_TYPE", referencedColumnName = "CODE_PRODUCT", nullable = false)
    private String codeProductType;

    @ManyToOne
    @JoinColumn(name = "CODE_SEGMENT", referencedColumnName = "CODE_PRODUCT", nullable = true)
    private String codeSegment;

    @ManyToOne
    @JoinColumn(name = "CODE_INTEREST_RATE", referencedColumnName = "CODE_PRODUCT", nullable = false)
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
    private BigDecimal minOpeningBalance;

    public Product(String codeProduct) {
        this.codeProduct = codeProduct;
    }
}
