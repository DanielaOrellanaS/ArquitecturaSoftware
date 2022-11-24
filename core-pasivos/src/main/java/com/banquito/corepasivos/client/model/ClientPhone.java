package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PHONE")
@IdClass(ClientPhonePK.class)
@NoArgsConstructor
public class ClientPhone {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private ClientPhonePK phonePk;
    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;

    public ClientPhone(ClientPhonePK phonePk) {
        this.phonePk = phonePk;
    }
}