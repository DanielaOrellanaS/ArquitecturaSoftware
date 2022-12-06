package com.banquito.corepasivos.account.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AccountAssociatedServiceParamPK implements Serializable {

        @Column(name = "code_param", length = 16, nullable = false)
        private String codeparam;

        @Column(name = "code_associated_service", length = 16, nullable = false)
        private String codeassociatedservice;

        @Column(name = "code_local_account", length = 20, nullable = false)
        private String codelocalaccount;

        @Column(name = "code_international_account", length = 34, nullable = false)
        private String codeinternationalaccount;

        @Column(name = "code_product", length = 32, nullable = false)
        private String codeproduct;

        @Column(name = "code_product_type", length = 32, nullable = false)
        private String codeproducttype;
}
