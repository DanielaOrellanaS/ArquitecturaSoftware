package com.banquito.corepasivos.general.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRANCH")
@Data
@NoArgsConstructor
public class Branch {
    @EmbeddedId
    private BranchPK key;
    @Column(name = "CODE_LOCATION", nullable = false)
    private Integer codeLocation;
    @Column(name = "INTERNATIONAL_BRANCH_CODE", length = 8, nullable = false)
    private String internationalBranchCode;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
}
