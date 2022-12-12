package com.banquito.corepasivos.general.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.banquito.corepasivos.account.model.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "branch")
public class Branch implements Serializable {

    @EmbeddedId
    @Include
    private BranchPK pk;

    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "international_branch_code", length = 8, nullable = false)
    private String internationalBranchCode;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "entity_bank_code", referencedColumnName = "entity_bank_code", insertable = false, updatable = false, nullable = true),
            @JoinColumn(name = "international_bank_code", referencedColumnName = "international_bank_code", insertable = false, updatable = false, nullable = true)
    })
    private BankEntity bankEntity;

    @ManyToOne
    @JoinColumn(name = "code_location", nullable = false, insertable = false, updatable = false)
    private LocationEntity locationEntity;

    public Branch(BranchPK pk) {
        this.pk = pk;
    }
}
