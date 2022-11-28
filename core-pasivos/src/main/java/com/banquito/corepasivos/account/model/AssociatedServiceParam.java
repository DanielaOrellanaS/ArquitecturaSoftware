package com.banquito.corepasivos.account.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "associated_service_param")
@Data
@NoArgsConstructor
public class AssociatedServiceParam {

    @EmbeddedId
    private AssociatedServiceParamPK key;

    @Column(name = "VALUE_TYPE", length = 3, nullable = false)
    private String valueType;

    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
}
