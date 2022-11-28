package com.banquito.corepasivos.product.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "associated_service_param")
@Data
@NoArgsConstructor
public class AssociatedServiceParam {

    @EmbeddedId
    private AssociatedServiceParamPK pk;

    @Column(name = "value_type", length = 3, nullable = false)
    private String valueType;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    public AssociatedServiceParam(AssociatedServiceParamPK pk) {
        this.pk = pk;
    }

}
