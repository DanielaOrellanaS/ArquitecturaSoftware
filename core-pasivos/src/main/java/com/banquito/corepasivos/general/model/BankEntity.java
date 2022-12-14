package com.banquito.corepasivos.general.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bank_entity")
public class BankEntity implements Serializable {
    @EmbeddedId
    @Include
    private BankEntityPK pk;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "entity_bank_code", referencedColumnName = "entity_bank_code", insertable = false, updatable = false, nullable = true),
            @JoinColumn(name = "international_bank_code", referencedColumnName = "international_bank_code", insertable = false, updatable = false, nullable = true)
    })
    private List<Branch> branches;

    public BankEntity(BankEntityPK pk) {
        this.pk = pk;
    }
}
