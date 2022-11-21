package com.banquito.accounts.model;

public class AssociatedService {
    private String codeAsociatedService;
    private String name;
    private String allowPayment;
    private String paymetMethod;
    private String chargeVat;
    private double fee;

    public AssociatedService() {
    }

    public AssociatedService(String codeAsociatedService, String name, String allowPayment, String paymetMethod,
            String chargeVat, double fee) {
        this.codeAsociatedService = codeAsociatedService;
        this.name = name;
        this.allowPayment = allowPayment;
        this.paymetMethod = paymetMethod;
        this.chargeVat = chargeVat;
        this.fee = fee;
    }

    public String getCodeAsociatedService() {
        return codeAsociatedService;
    }

    public void setCodeAsociatedService(String codeAsociatedService) {
        this.codeAsociatedService = codeAsociatedService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllowPayment() {
        return allowPayment;
    }

    public void setAllowPayment(String allowPayment) {
        this.allowPayment = allowPayment;
    }

    public String getPaymetMethod() {
        return paymetMethod;
    }

    public void setPaymetMethod(String paymetMethod) {
        this.paymetMethod = paymetMethod;
    }

    public String getChargeVat() {
        return chargeVat;
    }

    public void setChargeVat(String chargeVat) {
        this.chargeVat = chargeVat;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

}