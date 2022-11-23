package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BANK_ENTITY")
public class BankEntity {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_BANK_ENTITY", length = 16, nullable = false)
    private String codeBankEntity;
    @Column(name = "CODE_BANK_INTERNATIONAL", length = 16, nullable = false)
    private String codeBankInternational;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    public BankEntity(String codeBankEntity) {
        this.codeBankEntity = codeBankEntity;
    }
}
