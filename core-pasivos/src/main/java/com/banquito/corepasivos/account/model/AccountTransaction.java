package com.banquito.corepasivos.account.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_transaction")
public class AccountTransaction {

    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TRANSACTION_SEQ")
    @SequenceGenerator(sequenceName = "account_transaction_code_transaction_seq", allocationSize = 1, name = "ACCOUNT_TRANSACTION_SEQ")*/
    @Column(name = "code_transaction", nullable = false)
    private Integer codeTransaction;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_account", referencedColumnName = "code_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account", insertable = false, updatable = false),
            @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account" , insertable = false, updatable = false)
    })
    private Account account;

    @Column(name = "code_unique_transaction", length = 64, nullable = false)
    private String codeUniqueTransaction;

    @Column(name = "type", length = 3, nullable = false)
    private String type;

    @Column(name = "recipient_account_number", length = 34, nullable = false)
    private String recipientAccountNumber;

    @Column(name = "recipient_type", length = 3, nullable = false)
    private String recipientType;

    @Column(name = "recipient_bank", length = 64, nullable = false)
    private String recipientBank;

    @Column(name = "reference", length = 64, nullable = false)
    private String reference;

    @Column(name = "description", length = 128, nullable = true)
    private String description;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "execute_date", nullable = true)
    private Date executeDate;

    @Column(name = "status", length = 3, nullable = false)
    private String status;
}
