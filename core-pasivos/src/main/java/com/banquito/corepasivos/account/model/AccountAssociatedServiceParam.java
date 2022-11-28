package com.banquito.corepasivos.account.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_asso_service_param")
public class AccountAssociatedServiceParam {
    @EmbeddedId
    private AccountAssociatedServicePK pk;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Column(name = "text_value", length = 128, nullable = true)
    private String textValue;

    @Column(name = "date_value", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateValue;

    @Column(name = "number_value", nullable = true)
    private BigDecimal numberValue;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_param", referencedColumnName = "code_param", insertable = false, updatable = false),
            @JoinColumn(name = "code_associated_service", referencedColumnName = "code_associated_service", insertable = false, updatable = false),
    })
    private AssociatedServiceParam associatedServiceParam;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_account", referencedColumnName = "code_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_product", referencedColumnName = "code_product", insertable = false, updatable = false),
            @JoinColumn(name = "code_product_type", referencedColumnName = "code_product_type", insertable = false, updatable = false),
    })
    private AccountAssociatedService associatedService;

    public AccountAssociatedServiceParam(AccountAssociatedServicePK pk) {
        this.pk = pk;
    }
}