package com.banquito.corepasivos.account.model;

import com.banquito.corepasivos.product.model.ProductAssociatedService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_associated_service")
public class AccountAssociatedService {

    @EmbeddedId
    private AccountAssociatedServicePK pk;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date starDate;

    @Column(name = "end_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_account", referencedColumnName = "code_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false),
    })
    private Account account;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_product", referencedColumnName = "code_product", insertable = false, updatable = false),
            @JoinColumn(name = "code_product_type", referencedColumnName = "code_product_type", insertable = false, updatable = false),
            @JoinColumn(name = "code_associated_service", referencedColumnName = "code_associated_service", insertable = false, updatable = false),
    })
    private ProductAssociatedService productAssociatedService;

    public AccountAssociatedService(AccountAssociatedServicePK pk) {
        this.pk = pk;
    }
}
