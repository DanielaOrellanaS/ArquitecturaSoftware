package com.banquito.corepasivos.client.model;

import com.banquito.corepasivos.general.model.LocationEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "code_client", referencedColumnName = "code_client", insertable = false, updatable = false),
            @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false),
            @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false)
    })
    private Client client;
    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "code_location", referencedColumnName = "code_location",
     * insertable = false, updatable = false)
     * private LocationEntity locationEntity;
     */

    public ClientAddress(ClientAddressPK pk) {
        this.pk = pk;
    }
}