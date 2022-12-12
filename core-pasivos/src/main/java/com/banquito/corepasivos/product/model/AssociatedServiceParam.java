package com.banquito.corepasivos.product.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "associated_service_param")
@Data
@NoArgsConstructor
public class AssociatedServiceParam implements Serializable {

    @EmbeddedId
    private AssociatedServiceParamPK pk;

    @Column(name = "value_type", length = 3, nullable = false)
    private String valueType;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "code_associated_service", insertable = false, updatable = false)
    private AssociatedService associatedService;

    public AssociatedServiceParam(AssociatedServiceParamPK pk) {
        this.pk = pk;
    }

}
