package com.banquito.corepasivos.config.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@IdClass(AssociatedServiceParamKey.class)
@Table(name="ASSOCIATED_SERVICE_PARAM")
public class AssociatedServiceParam {

    @EqualsAndHashCode.Include
    @Id
    @Column(name="CODE_PARAM", length=16, nullable=false)
    private String codeParam;

    @Id
    @ManyToOne
    @JoinColumn(name="CODE_ASSOCIATED_SERVICE", nullable=false)
    private AssociatedService codeAssociatedService;

    @Column(name="VALUE_TYPE", length=3, nullable=false)
    private String valueType;

    @Column(name="NAME", length=64, nullable=false)
    private String name;

    public AssociatedServiceParam(String codeParam) {
        this.codeParam = codeParam;
    }
}