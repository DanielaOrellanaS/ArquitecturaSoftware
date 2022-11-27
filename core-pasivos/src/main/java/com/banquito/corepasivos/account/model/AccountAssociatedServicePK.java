package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AccountAssociatedServicePK implements Serializable {
        @Column(name = "CODE_ACCOUNT", nullable = false)
        private Integer codeAccount;
        @Column(name = "CODE_LOCAL_ACCOUNT", length = 20, nullable = false)
        private String codeLocalAccount;
        @Column(name = "CODE_INTERNATIONAL_ACCOUNT", length = 34, nullable = false)
        private String codeInternationalAccount;
        @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
        private String associatedService;
        @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
        private String codeProduct;
        @Column(name = "CODE_PRODUCT_TYPE", length = 32, nullable = false)
        private String codeProductType;

}