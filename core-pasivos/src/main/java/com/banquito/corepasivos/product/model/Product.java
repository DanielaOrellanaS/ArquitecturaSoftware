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

import com.banquito.corepasivos.client.model.Segment;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private String codeProduct;

    @ManyToOne
    @JoinColumn(name = "CODE_PRODUCT_TYPE", insertable = false, updatable = false, nullable = false)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "CODE_SEGMENT", insertable = false, updatable = false)
    private Segment segment;

    @ManyToOne
    @JoinColumn(name = "CODE_INTEREST_RATE", insertable = false, updatable = false)
    private InterestRate interestRate;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "TEMPORALITY_ACCOUNT_STATE", length = 3)
    private String temporalityAccountState;

    @Column(name = "USE_CHECKBOOK", length = 1)
    private String useCheckbook;

    @Column(name = "ALLOW_TRANSFERENCES", length = 1)
    private String allowTransferences;

    @Column(name = "TYPE_CLIENT", length = 3)
    private String typeClient;

    @Column(name = "MIN_OPENING_BALANCE", scale = 17, precision = 2, nullable = false)
    private BigDecimal minOpeningBalance;

    public Product(String codeProduct) {
        this.codeProduct = codeProduct;
    }
}
