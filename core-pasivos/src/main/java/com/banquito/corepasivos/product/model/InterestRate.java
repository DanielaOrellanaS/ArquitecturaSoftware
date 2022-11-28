package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interest_rate")
@Data
@NoArgsConstructor

public class InterestRate {

    @Id
    @Column(name = "code_interest_rate", length = 8, nullable = false)
    private String codeInterestRate;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "type", nullable = false, length = 3)
    private String type;

    @Column(name = "calc_base", nullable = false, length = 8)
    private String calcBase;

    public InterestRate(String codeInterestRate) {
        this.codeInterestRate = codeInterestRate;
    }

}
