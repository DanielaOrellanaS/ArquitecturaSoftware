package com.banquito.corepasivos.product.model;

import lombok.*;
import javax.persistence.*;

@Data
@Embeddable
public class AssociatedServiceParamPK{
    @Column(name="CODE_PARAM", length=16, nullable=false)
    private String codeParam;

    @Column(name="CODE_ASSOCIATED_SERVICE", length=16, nullable=false)
    private String codeAssociatedService;

}
