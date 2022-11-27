package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.JoinColumns;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.banquito.corepasivos.client.model.Client;

import lombok.Data;

@Data
@Embeddable
public class AccountSignaturePK implements Serializable {

        @Column(name = "CODE_ACCOUNT", nullable = false)
        private Integer codeAccount;
        @Column(name = "CODE_LOCAL_ACCOUNT", length = 20, nullable = false)
        private String codeLocalAccount;
        @Column(name = "CODE_INTERNATIONAL_ACCOUNT", length = 34, nullable = false)
        private String codeInternationalAccount;
        @Column(name = "CODE_CLIENT", nullable = false)
        private Integer codeClient;
        @Column(name = "IDENTIFICATION_TYPE", length = 3, nullable = false)
        private String identificationType;
        @Column(name = "IDENTIFICATION", length = 20, nullable = false)
        private String identification;

}
