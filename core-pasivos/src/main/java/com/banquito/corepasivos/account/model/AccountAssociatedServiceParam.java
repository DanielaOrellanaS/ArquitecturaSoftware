package com.banquito.corepasivos.config.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@IdClass(AssociatedServiceParamKey.class)
@Entity
@Table(name="ASSOCIATED_SERVICE_PARAM")
public class AssociatedServiceParam {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private AssociatedServiceParamKey associatedServiceParamKey;

    @Column(name="VALUE_TYPE", length=3, nullable=false)
    private String valueType;

    @Column(name="NAME", length=64, nullable=false)
    private String name;

    public AssociatedServiceParam(AssociatedServiceParamKey associatedServiceParamKey) {
        this.associatedServiceParamKey = associatedServiceParamKey;
    }
}