package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BANK_ENTITY")
public class BankEntity implements Serializable {
    @EmbeddedId
    @Include
    private BankEntityPK pk;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    public BankEntity(BankEntityPK pk) {
        this.pk = pk;
    }
}
