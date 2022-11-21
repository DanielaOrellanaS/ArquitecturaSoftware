package com.banquito.accounts.model;

import java.math.BigDecimal;

public class ProductAssociatedService {
    private ProductAssociatedServicePK pk;
    private BigDecimal fee;

    public ProductAssociatedService() {
    }

    public ProductAssociatedService(ProductAssociatedServicePK pk, BigDecimal fee) {
        this.pk = pk;
        this.fee = fee;
    }

    public ProductAssociatedServicePK getPk() {
        return pk;
    }

    public void setPk(ProductAssociatedServicePK pk) {
        this.pk = pk;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

}
