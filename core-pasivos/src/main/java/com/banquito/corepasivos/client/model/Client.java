package com.banquito.corepasivos.client.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @EmbeddedId
    private ClientPK pk;

    @Column(name = "client_type", nullable = false, length = 3)
    private String clientType;

    @Column(name = "lastname", nullable = false, length = 64)
    private String lastname;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "fullname", nullable = false, length = 128)
    private String fullname;

    @Column(name = "email", nullable = false, length = 128, unique = true)
    private String email;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "company_name", nullable = true, length = 120)
    private String companyName;

    @Column(name = "company_type", nullable = true, length = 16)
    private String companyType;

    @Column(name = "status", nullable = false, length = 3)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_status_date", nullable = false)
    private Date lastStatusDate;

    @Column(name = "signature", nullable = false, length = 128)
    private String signature;

    @Column(name = "work_status", nullable = false, length = 3)
    private String workStatus;

    @Column(name = "tax_payment_place", nullable = false, length = 2)
    private String taxPaymentPlace;

    @Column(name = "fingerprint", nullable = false, length = 10)
    private String fingerprint;

    @Column(name = "nationality", nullable = false, length = 64)
    private String nationality;

    @Column(name = "marital_status", nullable = false, length = 3)
    private String maritalStatus;

    @Column(name = "monthly_avg_income", nullable = false, length = 32)
    private String monthlyAvgIncome;

    @Column(name = "basic_services_document", nullable = true, length = 2048)
    private String basicServicesDocument;

    @Column(name = "income_tax_document", nullable = true, length = 2048)
    private String incomeTaxDocument;

    @Column(name = "articles_association_doc", nullable = true, length = 2048)
    private String articlesAssociationDoc;

    @Column(name = "tin_document", nullable = true, length = 2048)
    private String tinDocument;

    @Column(name = "app_legal_represent_doc", nullable = true, length = 2048)
    private String appLegalRepresentDoc;

    @Column(name = "career", nullable = false, length = 64)
    private String career;

    @ManyToOne
    @JoinColumn(name = "code_segment", referencedColumnName = "code_segment", insertable = false, updatable = false)
    private Segment codeSegment;

    public Client(ClientPK pk) {
        this.pk = pk;
    }
}
