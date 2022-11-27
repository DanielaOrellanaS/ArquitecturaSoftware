package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Embeddable

public class AccountAssociatedServiceParamPK implements Serializable {

        @Column(name = "CODE_PARAM", length = 16, nullable = false)
        private String codeParam;
        @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
        private String codeAssociatedService;
        @Column(name = "CODE_ACCOUNT", nullable = false)
        private Integer codeAccount;
        @Column(name = "CODE_LOCAL_ACCOUNT", length = 20, nullable = false)
        private String codeLocalAccount;
        @Column(name = "CODE_INTERNATIONAL_ACCOUNT", length = 34, nullable = false)
        private String codeInternationalAccount;
        @Column(name = "CODE_ACCOUNT_ASSO_SERVICE", length = 16, nullable = false)
        private String codeAccountAssoService;
        @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
        private String codeProduct;
        @Column(name = "CODE_PRODUCT_TYPE", length = 32, nullable = false)
        private String codeProductType;

}
