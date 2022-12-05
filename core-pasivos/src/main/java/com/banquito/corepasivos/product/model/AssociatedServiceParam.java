package com.banquito.corepasivos.product.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.banquito.corepasivos.account.model.AccountAssociatedServiceParam;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "code_associated_service", insertable = false, updatable = false)
    private AssociatedService associatedService;

/*     @JsonManagedReference
    @OneToMany(mappedBy = "associated_service_param")
    private List<AccountAssociatedServiceParam> accountAssociatedServiceParams; */

    public AssociatedServiceParam(AssociatedServiceParamPK pk) {
        this.pk = pk;
    }

}
