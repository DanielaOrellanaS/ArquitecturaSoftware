package com.banquito.corepasivos.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ASSOCIATED_SERVICE")
@NoArgsConstructor
public class AssociatedService {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_ASSOCIATED_SERVICE", length = 16, nullable = false)
    private String codeAssociatedService;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "ALLOW_PAYMENT", length = 1, nullable = false)
    private String allowPayment;
    @Column(name = "PAYMENT_METHOD", length = 3)
    private String pymentMethod;
    @Column(name = "CHARGE_VAT", length = 1, nullable = false)
    private String ChargeVat;
    @Column(name = "FEE", nullable = false)
    private BigDecimal fee;
}
