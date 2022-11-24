package com.banquito.corepasivos.config.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name="ASSOCIATED_SERVICE")
public class AssociatedService {

    @EqualsAndHashCode.Include
    @Id
    @Column(name="CODE_ASSOCIATED_SERVICE", length=16, nullable=false)
    private String codeAssociatedService;

    @Column(name="NAME", length=64, nullable=false)
    private String name;

    @Column(name="ALLOW_PAYMENT", length=1, nullable=false)
    private String allowPayment;

    @Column(name="PAYMENT_METHOD", length=3, nullable=true)
    private String paymentMethod;

    @Column(name="CHARGE_VAT", length=1, nullable=false)
    private String chargeVat;

    @Column(name="FEE", nullable=false)
    private BigDecimal fee;

    public AssociatedService(String codeAssociatedService) {
        this.codeAssociatedService = codeAssociatedService;
    }
}
