package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AccountClientPK implements Serializable {

        @Column(name = "code_local_account", length = 20, nullable = false)
        private String codelocalaccount;

        @Column(name = "code_international_account", length = 34, nullable = false)
        private String codeinternationalaccount;

        @Column(name = "identification_type", length = 3, nullable = false)
        private String identificationtype;

        @Column(name = "identification", length = 20, nullable = false)
        private String identification;
}
