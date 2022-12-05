package com.banquito.corepasivos.general.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@NoArgsConstructor
@Entity
@Table(name = "branch")
public class Branch implements Serializable{

    @EmbeddedId
    @Include
    private BranchPK pk;

    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "INTERNATIONAL_BRANCH_CODE", length = 8, nullable = false)
    private String internationalBranchCode;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "entity_bank_code", referencedColumnName = "entity_bank_code", insertable = false, updatable = false, nullable = true),
            @JoinColumn(name = "international_bank_code", referencedColumnName = "international_bank_code", insertable = false, updatable = false, nullable = true)
    })
    private BankEntity bankEntity;

    @ManyToOne
    @JoinColumn(name = "CODE_LOCATION", nullable = false, insertable = false, updatable = false)
    private LocationEntity locationEntity;

    public Branch(BranchPK pk) {
        this.pk = pk;
    }
}
