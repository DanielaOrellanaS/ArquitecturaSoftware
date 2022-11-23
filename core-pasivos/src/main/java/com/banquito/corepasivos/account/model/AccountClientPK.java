package com.banquito.corepasivos.account.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter 
public class AccountClientPK implements Serializable{
    @EqualsAndHashCode.Include
    @Column(name = "CODE_ACCOUNT", nullable= false)
    private Integer codeAccount;
    @EqualsAndHashCode.Include
    @Column(name = "CODE_CLIENT", nullable= false)
    private Integer codeClient;
    
    public AccountClientPK(Integer codeAccount, Integer codeClient){
        this.codeAccount = codeAccount;
        this.codeClient = codeClient;
    }


}
