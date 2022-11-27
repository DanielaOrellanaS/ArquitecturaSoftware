package com.banquito.corepasivos.client.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="CLIENT")
public class Client {

    @EqualsAndHashCode.Include
    @EmbeddedId
    ClientPK clientPK;

    @Column(name="CODE_SEGMMENT", length=16, nullable=false)
    private String codeSegment;
    @Column(name="CLIENT_TYPE",nullable=false,length = 3)
    private String clientType;
    @Column(name="IDENTIFICATION_TYPE",nullable=false,length = 3)
    private String identificationType;
    @Column(name="IDENTIFICATION",nullable=false,length = 20)
    private String identification;
    @Column(name="LASTNAME",nullable=false,length = 64)
    private String lastname;
    @Column(name="NAME",nullable=false,length = 64)
    private String name;
    @Column(name="FULLNAME",nullable=false,length = 128)
    private String fullname;
    @Column(name="EMAIL",nullable=false,length = 128,unique = true)
    private String email;
    @Column(name="BIRTH_DATE",nullable=false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name="GENDER",nullable=false,length = 1)
    private String gender;
    @Column(name="COMPANY_NAME",nullable=true,length = 120)
    private String companyName;
    @Column(name="COMPANY_TYPE",nullable=true,length = 16)
    private String companyType;
    @Column(name="STATUS",nullable=false,length = 3)
    private String status;
    @Column(name="CREATE_DATE",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDate;
    @Column(name="LAST_STATUS_DATE",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastStatusDate;
    @Column(name="SIGNATURE",nullable=false,length = 128)
    private String signature;
    @Column(name="WORK_STATUS",nullable=false,length = 3)
    private String workStatus;
    @Column(name="TAX_PAYMENT_PLACE",nullable=false,length = 2)
    private String taxPaymentPlace;
    @Column(name="FINGERPRINT",nullable=false,length = 10)
    private String fingerprint;
    @Column(name="NATIONALITY",nullable=false,length = 64)
    private String nationality;
    @Column(name="MARITAL_STATUS",nullable=false,length = 3)
    private String maritalStatus;
    @Column(name="MONTHLY_AVG_INCOME",nullable=false,length = 32)
    private String monthlyAvgIncome;
    @Column(name="BASIC_SERVICES_DOCUMENT",nullable=true,length = 2048)
    private String basicServicesDocument;
    @Column(name="INCOME_TAX_DOCUMENT",nullable=true,length = 2048)
    private String incomeTaxDocument;
    @Column(name="ARTICLES_ASSOCIATION_DOC",nullable=true,length = 2048)
    private String articlesAssociationDoc;
    @Column(name="TIN_DOCUMENT",nullable=true,length = 2048)
    private String tinDocument;
    @Column(name="APP_LEGAL_REPRESENT_DOC",nullable=true,length = 2048)
    private String appLegalRepresentDoc;
    @Column(name="CAREER",nullable=false,length = 64)
    private String career;

    public Client(ClientPK clientPK){
        this.clientPK = clientPK;
    }
}
