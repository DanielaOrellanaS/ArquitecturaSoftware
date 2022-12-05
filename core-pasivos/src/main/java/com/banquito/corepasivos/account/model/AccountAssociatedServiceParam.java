package com.banquito.corepasivos.account.model;

import com.banquito.corepasivos.product.model.AssociatedServiceParam;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_asso_service_param")
public class AccountAssociatedServiceParam implements Serializable {
    @EmbeddedId
    @Include
    private AccountAssociatedServiceParamPK pk;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Column(name = "text_value", length = 128, nullable = true)
    private String textValue;

    @Column(name = "date_value", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateValue;

    @Column(name = "number_value", scale = 17, precision = 2, nullable = true)
    private BigDecimal numberValue;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_param", referencedColumnName = "code_param", insertable = false, updatable = false),
            @JoinColumn(name = "code_associated_service", referencedColumnName = "code_associated_service", insertable = false, updatable = false),
    })
    private AssociatedServiceParam associatedServiceParam;

    @JsonBackReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_product", referencedColumnName = "code_product", insertable = false, updatable = false),
            @JoinColumn(name = "code_product_type", referencedColumnName = "code_product_type", insertable = false, updatable = false),
    })
    private AccountAssociatedService accountAssociatedService;

    public AccountAssociatedServiceParam(AccountAssociatedServiceParamPK pk) {
        this.pk = pk;
    }
}
