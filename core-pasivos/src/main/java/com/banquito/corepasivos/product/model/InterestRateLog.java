package com.banquito.corepasivos.product.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "interest_rate_log")
public class InterestRateLog {

    @Id
    @Column(name = "code_interest_log", length = 8, nullable = false)
    private String codeInterestLog;

    @Column(name = "code_interest_rate", length = 8, nullable = false)
    private String codeInterestRate;

    @Column(name = "value", scale = 5, precision = 2, nullable = false)
    private BigDecimal value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    // @ManyToOne
    // @JoinColumn(name = "code_interest_rate", referencedColumnName = "code_interest_rate", insertable = false, updatable = false, nullable = true)
    // private InterestRate interestRate;

    public InterestRateLog(String codeInteresLog) {
        this.codeInterestLog = codeInteresLog;
    }

}