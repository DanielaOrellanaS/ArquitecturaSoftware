package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_address")
public class ClientAddress {

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

    // @ManyToOne
    // @JoinColumns({
    //         @JoinColumn(name = "identification_type", referencedColumnName = "identification_type", insertable = false, updatable = false, nullable = false),
    //         @JoinColumn(name = "identification", referencedColumnName = "identification", insertable = false, updatable = false, nullable = false)
    // })
    // private Client client;

    // @ManyToOne
    // @JoinColumn(name = "code_location", referencedColumnName = "code_location", insertable = false, updatable = false, nullable = false)
    // private LocationEntity locationEntity;

    public ClientAddress(ClientAddressPK pk) {
        this.pk = pk;
    }
}
