package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class AccountSignaturePK implements Serializable {

        @Column(name = "code_local_account", length = 20, nullable = false)
        private String codeLocalAccount;

        @Column(name = "code_international_account", length = 34, nullable = false)
        private String codeInternationalAccount;

        @Column(name = "code_client", nullable = false)
        private Integer codeClient;

        @Column(name = "identification_type", length = 3, nullable = false)
        private String identificationType;

        @Column(name = "identification", length = 20, nullable = false)
        private String identification;

}
