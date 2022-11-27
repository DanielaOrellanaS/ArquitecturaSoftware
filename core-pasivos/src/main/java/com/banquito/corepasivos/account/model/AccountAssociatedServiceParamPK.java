package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;

import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Embeddable

public class AccountAssociatedServiceParamPK implements Serializable {

    @OneToMany
   @JoinColumns({
           @JoinColumn(name = "code_account", referencedColumnName = "code_account"),
           @JoinColumn(name = "code_local_account", referencedColumnName = "code_local_account"),
           @JoinColumn(name = "code_international_account", referencedColumnName = "code_international_account"),
           @JoinColumn(name = "code_account_asso_service", referencedColumnName = "code_account_asso_service"),
           @JoinColumn(name = "code_product", referencedColumnName = "code_product"),
           @JoinColumn(name = "code_product_type", referencedColumnName = "code_product_type")
   })
   private AccountAssociatedService accountAssociatedService;

   @OneToMany
   @JoinColumns({
           @JoinColumn(name = "code_param", referencedColumnName = "code_param"),
           @JoinColumn(name = "code_associated_service", referencedColumnName = "code_associated_service"),
           
   })
   private AssociatedServiceParam associatedServiceParam;
    

}
