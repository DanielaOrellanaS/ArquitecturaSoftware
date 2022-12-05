package com.banquito.corepasivos.account.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AccountSignaturePK implements Serializable {

        @Column(name = "code_local_account", length = 20, nullable = false)
        private String codelocalaccount;

        @Column(name = "code_international_account", length = 34, nullable = false)
        private String codeinternationalaccount;

        @Column(name = "identification_type", length = 3, nullable = false)
        private String identificationtype;

        @Column(name = "identification", length = 20, nullable = false)
        private String identification;

}
