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
@Table(name = "BRANCH")
public class Branch {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_BRANCH", length = 3, nullable = false)
    private String code;
    @Column(name = "CODE_BANK_ENTITY", length = 16, nullable = false)
    private BankEntity codeBankEntity;
    @Column(name = "CODE_LOCATION", length = 4, nullable = false)
    private GeoLocation codeLocation;
    @Column(name = "CODE_BANK_INTERNATIONAL", length = 8, nullable = false)
    private String codeBankInternational;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    public Branch(String code) {
        this.code = code;
    }
}
