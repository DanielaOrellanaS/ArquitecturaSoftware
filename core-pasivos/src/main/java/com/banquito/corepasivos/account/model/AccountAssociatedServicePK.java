package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable

public class AccountAssociatedServicePK implements Serializable{

   @Column(name = "code_account", nullable = false)
   private Integer codeAccount;
   @Column(name = "code_local_account", length = 20, nullable = false)
   private String codeLocalAccount;
   @Column(name = "code_international_account", length = 34, nullable = false)
   private String codeInternationalAccount;
   @Column(name = "code_associated_service", length = 16, nullable = false)
   private String codeAssociatedService;
   @Column(name = "code_product", length = 32, nullable = false)
   private String codeProduct;
   @Column(name = "code_product_type", length = 32, nullable = false)
   private String codeProductType;

   public AccountAssociatedServicePK(Integer codeAcount, String codeLocalAcount, String codeInternationalAccount,
   String codeAssociatedService, String codeProduct,String codeProductType){
    this.codeAccount = codeAcount;
    this.codeLocalAccount = codeLocalAcount;
    this.codeInternationalAccount = codeInternationalAccount;
    this.codeAssociatedService = codeAssociatedService;
    this.codeProduct = codeProduct;
    this.codeProductType = codeProductType;
   }
   


}