package com.banquito.corepasivos.account.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AccountPK implements Serializable {

    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
    @SequenceGenerator(sequenceName = "account_code_account_seq", allocationSize = 1, name = "ACCOUNT_SEQ")*/
    @Column(name = "code_account", nullable = false)
    private Integer codeAccount;

    @Column(name = "code_local_account", length = 20, nullable = false)
    private String codeLocalAccount;

    @Column(name = "code_international_account", length = 34, nullable = false)
    private String codeInternationalAccount;
}
