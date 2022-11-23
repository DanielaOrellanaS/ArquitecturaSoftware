package com.banquito.corepasivos.service.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_TRANSACTION", length = 16, nullable = false)
    private Integer codeTransaction;

    @Column(name = "CODE_ACCOUNT", nullable = true)
    private Integer codeAccount;

    @Column(name = "CODE_UNIQUE_TRANSACTION", nullable = false)
    private String codeUniqueTransaction;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "REFERENCE", nullable = false)
    private String reference;

    @Column(name = "VALUE", scale = 17, precision = 2, nullable = false)
    private Double value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false)
    private Timestamp createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXECUTE_DATE", nullable = false)
    private Timestamp executeDate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public Transaction(Integer codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

}
