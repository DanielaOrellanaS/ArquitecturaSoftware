package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_phone")
@Data
@NoArgsConstructor
public class Phone {
    @EmbeddedId
    private PhonePK pk;

    @Column(name = "type", length = 3, nullable = false)
    private String type;

    public Phone(PhonePK pk) {
        this.pk = pk;
    }
}