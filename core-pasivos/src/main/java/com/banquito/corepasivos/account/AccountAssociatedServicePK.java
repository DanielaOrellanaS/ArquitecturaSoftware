package com.banquito.corepasivos.account;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountAssociatedServicePK {

    @EqualsAndHashCode.Include
    @Column(name = "CODE_ACCOUNT", length = 4, nullable = false)
    private Integer codeAccount;

    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "CODE_PRODUCT", length = 32, nullable = false)
    private String codeProduct;
}