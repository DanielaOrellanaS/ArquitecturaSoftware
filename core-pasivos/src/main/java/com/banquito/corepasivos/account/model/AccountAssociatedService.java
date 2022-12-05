package com.banquito.corepasivos.account.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_associated_service")
public class AccountAssociatedService implements Serializable {

    @EmbeddedId
    private AccountAssociatedServicePK pk;

    @Column(name = "code_associated_service", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date starDate;

    @Column(name = "end_date", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account", insertable = false, updatable = false),
    })
    private Account account;

    // @ManyToOne
    // @JoinColumns({
    // @JoinColumn(name = "code_product", referencedColumnName = "code_product",
    // insertable = false, updatable = false),
    // @JoinColumn(name = "code_product_type", referencedColumnName =
    // "code_product_type", insertable = false, updatable = false),
    // @JoinColumn(name = "code_associated_service", referencedColumnName =
    // "code_associated_service", insertable = false, updatable = false),
    // })
    // private ProductAssociatedService productAssociatedService;

    @JsonManagedReference
    @OneToMany(mappedBy = "accountAssociatedService")
    private List<AccountAssociatedServiceParam> associatedServiceParams;

    public AccountAssociatedService(AccountAssociatedServicePK pk) {
        this.pk = pk;
    }
}
