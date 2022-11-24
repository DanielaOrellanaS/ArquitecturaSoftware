package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INTEREST_RATE")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InterestRate {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_INTEREST_RATE", nullable = false, length = 8)
    private String codeInterestRate;

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    @Column(name = "TYPE", nullable = false, length = 3)
    private String type;

    @Column(name = "CALC_BASE", nullable = false, length = 8)
    private String calcBase;

    public InterestRate(String codeInterestRate) {
        this.codeInterestRate = codeInterestRate;
    }
}
