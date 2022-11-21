package com.banquito.accounts.model;

public class ProductAssociatedServicePK {
    private String codeAssociatedService;
    private String codeProduct;

    public ProductAssociatedServicePK() {
    }

    public ProductAssociatedServicePK(String codeAssociatedService, String codeProduct) {
        this.codeAssociatedService = codeAssociatedService;
        this.codeProduct = codeProduct;
    }

    public String getCodeAssociatedService() {
        return codeAssociatedService;
    }

    public void setCodeAssociatedService(String codeAssociatedService) {
        this.codeAssociatedService = codeAssociatedService;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

}
