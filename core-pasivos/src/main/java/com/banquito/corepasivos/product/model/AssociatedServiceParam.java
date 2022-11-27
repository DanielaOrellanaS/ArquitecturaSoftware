package com.banquito.corepasivos.product.model;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="ASSOCIATED_SERVICE_PARAM")
public class AssociatedServiceParam {
    @EqualsAndHashCode.Include
    @EmbeddedId
    private AssociatedServiceParamPK pk;
    @Column(name="VALUE_TYPE", length=3, nullable=false)
    private String valueType;

    @Column(name="NAME", length=64, nullable=false)
    private String name;

    public AssociatedServiceParam(AssociatedServiceParamPK pk) {
        this.pk = pk;
    }
}