package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_address")
public class ClientAddress {

    @EmbeddedId
    private ClientAddressPK pk;

    @Column(name = "address_line_one", length = 64, nullable = false)
    private String addressLineOne;

    @Column(name = "address_line_two", length = 64, nullable = true)
    private String addressLineTwo;

    @Column(name = "latitude", length = 32, nullable = false)
    private String latitude;

    @Column(name = "longitude", length = 32, nullable = false)
    private String longitude;

    public ClientAddress(ClientAddressPK pk) {
        this.pk = pk;
    }

}