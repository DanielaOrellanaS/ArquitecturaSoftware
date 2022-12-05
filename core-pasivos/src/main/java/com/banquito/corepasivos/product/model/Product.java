package com.banquito.corepasivos.product.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.banquito.corepasivos.client.model.Segment;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product {

    @EmbeddedId
    private ProductPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "temporality_account_state", length = 3)
    private String temporalityAccountState;

    @Column(name = "use_checkbook", length = 1)
    private String useCheckbook;

    @Column(name = "allow_transferences", length = 1)
    private String allowTransferences;

    @Column(name = "type_client", length = 3)
    private String typeClient;

    @Column(name = "min_opening_balance", scale = 17, precision = 2, nullable = false)
    private BigDecimal minOpeningBalance;

    // @ManyToOne
    // @JoinColumn(name = "code_product_type", referencedColumnName =
    // "code_product_type", insertable = false, updatable = false, nullable = false)
    // private ProductType productType;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "code_segment", referencedColumnName = "code_segment", insertable = false, updatable = false)
    private Segment segment;

    // @ManyToOne
    // @JoinColumn(name = "code_interest_rate", referencedColumnName =
    // "code_interest_rate", insertable = false, updatable = false)
    // private InterestRate interestRate;

    // @OneToMany(mappedBy = "product")
    // private List<Account> accounts;

    // @OneToMany(mappedBy = "product")
    // private List<ProductAssociatedService> productAssociatedServices;

    public Product(ProductPK pk) {
        this.pk = pk;
    }

}
