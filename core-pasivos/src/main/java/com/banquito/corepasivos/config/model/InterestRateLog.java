package com.banquito.corepasivos.general.model;

import java.lang.annotation.Inherited;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="INTEREST_RATE_LOG")
public class InterestRateLog {
    @EqualsAndHashCode.Include
    @Id 
    @Column(name="CODE_INTEREST_LOG", length=8, nullable=false)
    private String codeInterestLog;
    @Column(name="CODE_INTEREST_RATE", length=8, nullable=false)
    private String codeInterestRate;
    @Column(name="VALUE", scale=5, precision=2, nullable=false)
    private Double value;
    @Column(name="START_DATE", nullable=false)
    @Temporal(TemporalType.Timestamp)
    private Timestamp startDate;
    @Column(name="START_DATE", nullable=true)
    @Temporal(TemporalType.Timestamp)
    private Timestamp endDate;
    @Column(name="STATUS", length=3, nullable=false)
    private String status;

    public InterestRateLog(String codeInteresLog){
        this.codeInterestLog = codeInteresLog;
    }

}