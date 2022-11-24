package com.banquito.corepasivos.account.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountAssociatedServiceParamPK {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_PARAM", length = 16, nullable = false)
    private String codeParam;
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_ACCOUNT", length = 4, nullable = false)
    private Integer codeAccount;
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_ACCOUNT_ASSO_SERVICE", length = 4, nullable = false)
    private String codeAccocuntAssociatedService;
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private int codeProduct;

    public AccountAssociatedServiceParamPK(String codeParam, String codeAssociatedService, Integer codeAccount,
            String codeAccocuntAssociatedService, int codeProduct) {
        this.codeParam = codeParam;
        this.codeAssociatedService = codeAssociatedService;
        this.codeAccount = codeAccount;
        this.codeAccocuntAssociatedService = codeAccocuntAssociatedService;
        this.codeProduct = codeProduct;
    }


}