package com.banquito.accounts.model;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class InterestRateLog {

    private String codeInterestLog;
    private String codeInterestRate;
    private BigDecimal value;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;

    public InterestRateLog() {
    }

    public InterestRateLog(String codeInterestLog, String codeInterestRate) {
        this.codeInterestLog = codeInterestLog;
        this.codeInterestRate = codeInterestRate;
    }

    public String getCodeInterestLog() {
        return codeInterestLog;
    }

    public void setCodeInterestLog(String codeInterestLog) {
        this.codeInterestLog = codeInterestLog;
    }

    public String getCodeInterestRate() {
        return codeInterestRate;
    }

    public void setCodeInterestRate(String codeInterestRate) {
        this.codeInterestRate = codeInterestRate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
