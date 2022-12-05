package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;

import javax.persistence.*;

import com.banquito.corepasivos.general.model.LocationEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_address")
public class ClientAddress implements Serializable {

    @EmbeddedId
    @Include
    private ClientAddressPK pk;

    @Column(name = "address_line_one", length = 64, nullable = false)
    private String addressLineOne;

    @Column(name = "address_line_two", length = 64, nullable = true)
    private String addressLineTwo;

    @Column(name = "latitude", length = 32, nullable = false)
    private String latitude;

    @Column(name = "longitude", length = 32, nullable = false)
    private String longitude;

    @JsonBackReference(value = "client-clientAddress")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false, nullable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false, nullable = false)
    })
    private Client client;

    @JsonBackReference(value = "locationEntity-clientAddress")
    @ManyToOne
    @JoinColumn(name = "code_location", referencedColumnName = "code_location", insertable = false, updatable = false, nullable = false)
    private LocationEntity locationEntity;

    public ClientAddress(ClientAddressPK pk) {
        this.pk = pk;
    }
}
