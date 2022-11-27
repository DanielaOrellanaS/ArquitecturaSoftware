package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENT_ADDRESS")
public class ClientAddress {
    @EqualsAndHashCode.Include
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