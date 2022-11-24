package com.banquito.corepasivos.account.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@IdClass(AccountAssociatedServicePK.class)
@Entity
@Table(name = "ASSOCIATED_SERVICE_PARAM")
public class AccountAssociatedServiceParam {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private AccountAssociatedServicePK associatedServiceParamKey;

    @Column(name = "VALUE_TYPE", length = 3, nullable = false)
    private String valueType;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;

    public AccountAssociatedServiceParam(AccountAssociatedServicePK associatedServiceParamKey) {
        this.associatedServiceParamKey = associatedServiceParamKey;
    }
}