package com.banquito.accounts.model;
import java.security.Timestamp;
import java.sql.Date;

public class Client {
    private int codeClient;
    private String cuentType;
    private String identificationType;
    private String identification;
    private String lastname;
    private String name;
    private String fullname;
    private String email;
    private Date birthDate;
    private String gender;
    private String companyName;
    private String companyType;
    private String status;
    private Timestamp createDate;
    private Timestamp lastStatusDate;
    private String signature;
    private String workStatus;
    private String taxPaymentPlace;
    private String fingerprint;
    private String nationality;
    private String maritalStatus;
    private double monthlyAvgIncome;
    private String basicServicesDocument;
    private String incomeTaxDocument;
    private String articlesAssociationDoc;
    private String tnDocument;
    private String appLegalRepresent;
    private String career;

    public Client() {
    }

    public Client(int codeClient) {
        this.codeClient = codeClient;
    }

    public int getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(int codeClient) {
        this.codeClient = codeClient;
    }

    public String getCuentType() {
        return cuentType;
    }

    public void setCuentType(String cuentType) {
        this.cuentType = cuentType;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Timestamp lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getTaxPaymentPlace() {
        return taxPaymentPlace;
    }

    public void setTaxPaymentPlace(String taxPaymentPlace) {
        this.taxPaymentPlace = taxPaymentPlace;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public double getMonthlyAvgIncome() {
        return monthlyAvgIncome;
    }

    public void setMonthlyAvgIncome(double monthlyAvgIncome) {
        this.monthlyAvgIncome = monthlyAvgIncome;
    }

    public String getBasicServicesDocument() {
        return basicServicesDocument;
    }

    public void setBasicServicesDocument(String basicServicesDocument) {
        this.basicServicesDocument = basicServicesDocument;
    }

    public String getIncomeTaxDocument() {
        return incomeTaxDocument;
    }

    public void setIncomeTaxDocument(String incomeTaxDocument) {
        this.incomeTaxDocument = incomeTaxDocument;
    }

    public String getArticlesAssociationDoc() {
        return articlesAssociationDoc;
    }

    public void setArticlesAssociationDoc(String articlesAssociationDoc) {
        this.articlesAssociationDoc = articlesAssociationDoc;
    }

    public String getTnDocument() {
        return tnDocument;
    }

    public void setTnDocument(String tnDocument) {
        this.tnDocument = tnDocument;
    }

    public String getAppLegalRepresent() {
        return appLegalRepresent;
    }

    public void setAppLegalRepresent(String appLegalRepresent) {
        this.appLegalRepresent = appLegalRepresent;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}