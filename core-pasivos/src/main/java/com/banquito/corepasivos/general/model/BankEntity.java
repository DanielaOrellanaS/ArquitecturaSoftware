package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BANK_ENTITY")
@Data
@NoArgsConstructor
public class BankEntity {
    @EmbeddedId
    private BankEntityPK pk;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    public BankEntity(BankEntityPK pk) {
        this.pk = pk;
    }
}
