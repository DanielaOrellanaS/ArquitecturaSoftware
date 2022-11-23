package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "CLIENT_ADRESS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientAddress {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeAddress;
    @EmbeddedId
    private ClientAddressPK clientAddressPk;
    @Column(name = "ADDRESS_LINE_ONE", length = 64)
    private String addressLineOne;
    @Column(name = "ADDRESS_LINE_TWO", length = 64)
    private String addressLineTwo;
    @Column(name = "LATITUDE", length = 32)
    private String latitude;
    @Column(name = "LONGITUDE", length = 32)
    private String longitude;
}
