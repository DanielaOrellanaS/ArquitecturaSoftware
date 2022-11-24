package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountAssociatedServiceParamPK implements Serializable {
    @EqualsAndHashCode.Include

    @Column(name = "CODE_PARAM", length = 16, nullable = false)
    private String codeParam;

    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "CODE_ACCOUNT", nullable = false)
    private Integer codeAccount;

    @Column(name = "CODE_ACCOUNT_ASSO_SERVICE", length = 16, nullable = false)
    private String codeAccocuntAssociatedService;

    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private String codeProduct;

    public AccountAssociatedServiceParamPK(String codeParam, String codeAssociatedService, Integer codeAccount,
            String codeAccocuntAssociatedService, String codeProduct) {
        this.codeParam = codeParam;
        this.codeAssociatedService = codeAssociatedService;
        this.codeAccount = codeAccount;
        this.codeAccocuntAssociatedService = codeAccocuntAssociatedService;
        this.codeProduct = codeProduct;
    }

}
