package com.banquito.corepasivos.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client_phone")
public class ClientPhone implements Serializable {

    @EmbeddedId
    private ClientPhonePK pk;

    @Column(name = "type", length = 3, nullable = false)
    private String type;

    public ClientPhone(ClientPhonePK pk) {
        this.pk = pk;
    }
}
