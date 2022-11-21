package com.banquito.accounts.model;
import java.security.Timestamp;
import java.sql.Date;
import javax.sql.rowset.serial.SerialArray;

public class Cuent {
    private SerialArray code_client;
    private String cuent_type;
    private String identification_type;
    private String identification;
    private String lastname;
    private String name;
    private String fullname;
    private String email;
    private Date birth_date;
    private String gender;
    private String company_name;
    private String company_type;
    private String status;
    private Timestamp create_date;
    private Timestamp last_status_date;
    private String signature;
    private String work_status;
    private String tax_payment_place;
    private String fingerprint;
    private String nationality;
    private String marital_status;
    private String monthly_avg_income;
    private String basic_services_document;
    private String income_tax_document;
    private String articles_association_doc;
    private String tn_document;
    private String app_legal_represent;
    private String career;

    public Cuent() {
    }

    public Cuent(SerialArray code_client) {
        this.code_client = code_client;
    }

    public SerialArray getCode_client() {
        return code_client;
    }

    public void setCode_client(SerialArray code_client) {
        this.code_client = code_client;
    }

    public String getCuent_type() {
        return cuent_type;
    }

    public void setCuent_type(String cuent_type) {
        this.cuent_type = cuent_type;
    }

    public String getIdentification_type() {
        return identification_type;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
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

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getLast_status_date() {
        return last_status_date;
    }

    public void setLast_status_date(Timestamp last_status_date) {
        this.last_status_date = last_status_date;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getWork_status() {
        return work_status;
    }

    public void setWork_status(String work_status) {
        this.work_status = work_status;
    }

    public String getTax_payment_place() {
        return tax_payment_place;
    }

    public void setTax_payment_place(String tax_payment_place) {
        this.tax_payment_place = tax_payment_place;
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

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getMonthly_avg_income() {
        return monthly_avg_income;
    }

    public void setMonthly_avg_income(String monthly_avg_income) {
        this.monthly_avg_income = monthly_avg_income;
    }

    public String getBasic_services_document() {
        return basic_services_document;
    }

    public void setBasic_services_document(String basic_services_document) {
        this.basic_services_document = basic_services_document;
    }

    public String getIncome_tax_document() {
        return income_tax_document;
    }

    public void setIncome_tax_document(String income_tax_document) {
        this.income_tax_document = income_tax_document;
    }

    public String getArticles_association_doc() {
        return articles_association_doc;
    }

    public void setArticles_association_doc(String articles_association_doc) {
        this.articles_association_doc = articles_association_doc;
    }

    public String getTn_document() {
        return tn_document;
    }

    public void setTn_document(String tn_document) {
        this.tn_document = tn_document;
    }

    public String getApp_legal_represent() {
        return app_legal_represent;
    }

    public void setApp_legal_represent(String app_legal_represent) {
        this.app_legal_represent = app_legal_represent;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}