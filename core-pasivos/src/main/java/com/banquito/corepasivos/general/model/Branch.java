package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "branch")
@Data
@NoArgsConstructor
public class Branch {
    @EmbeddedId
    private BranchPK pk;
    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;
    @Column(name = "INTERNATIONAL_BRANCH_CODE", length = 8, nullable = false)
    private String internationalBranchCode;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "code_location", referencedColumnName = "code_location", insertable = false, updatable = false, nullable = true)
    private LocationEntity locationEntity;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "entity_bank_code", referencedColumnName = "entity_bank_code", insertable = false, updatable = false, nullable = true),
            @JoinColumn(name = "international_bank_code", referencedColumnName = "international_bank_code", insertable = false, updatable = false, nullable = true)
    })
    private BankEntity bankEntity;

    public Branch(BranchPK pk) {
        this.pk = pk;
    }
}
