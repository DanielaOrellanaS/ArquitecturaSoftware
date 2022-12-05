package com.banquito.corepasivos.general.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference(value = "bank-branch")
    @OneToMany(mappedBy = "bankEntity")
    private List<Branch> branches;

    public BankEntity(BankEntityPK pk) {
        this.pk = pk;
    }
}
