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
@Table(name = "CLIENT_PHONE")
@IdClass(PhonePK.class)
@NoArgsConstructor
public class Phone {

    @EqualsAndHashCode.Include
    @EmbeddedId
    private PhonePK phonePk;
    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;

    public Phone(PhonePK phonePk) {
        this.phonePk = phonePk;
    }
}