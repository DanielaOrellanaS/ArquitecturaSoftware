package com.banquito.corepasivos.account.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "associated_service_param")
public class AssociatedServiceParam {
    @EqualsAndHashCode.Include
    @EmbeddedId
    private AssociatedServiceParamPK key;

    @Column(name = "VALUE_TYPE", length = 3, nullable = false)
    private String valueType;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
}
