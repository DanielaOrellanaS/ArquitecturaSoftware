package com.banquito.corepasivos.product.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INTEREST_RATE_LOG")
public class InterestRateLog {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_INTEREST_LOG", length = 8, nullable = false)
    private String codeInterestLog;
    @Column(name = "CODE_INTEREST_RATE", length = 8, nullable = false)
    private String codeInterestRate;
    @Column(name = "VALUE", scale = 5, precision = 2, nullable = false)
    private BigDecimal value;
    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startDate;
    @Column(name = "END_DATE", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endDate;
    @Column(name = "STATUS", length = 3, nullable = false)
    private String status;

    public InterestRateLog(String codeInteresLog) {
        this.codeInterestLog = codeInteresLog;
    }

}