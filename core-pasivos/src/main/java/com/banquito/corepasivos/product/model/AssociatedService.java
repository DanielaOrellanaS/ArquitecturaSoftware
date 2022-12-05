package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "associated_service")
@NoArgsConstructor
public class AssociatedService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_associated_service", length = 16, nullable = false)
    private String codeAssociatedService;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "allow_payment", length = 1, nullable = false)
    private String allowPayment;

    @Column(name = "payment_method", length = 3)
    private String paymentMethod;

    @Column(name = "charge_vat", length = 1, nullable = false)
    private String chargeVat;

    @Column(name = "fee", scale = 17, precision = 2, nullable = false)
    private BigDecimal fee;

    @JsonManagedReference(value = "associatedService-associatedServiceParam")
    @OneToMany(mappedBy = "associatedService")
    private List<AssociatedServiceParam> associatedServiceParams; 

    @JsonManagedReference(value = "associatedService-productAssociatedServices")
    @OneToMany(mappedBy = "associatedService")
    private List<ProductAssociatedService> productAssociatedServices;

    public AssociatedService(String codeAssociatedService) {
        this.codeAssociatedService = codeAssociatedService;
    }

}
