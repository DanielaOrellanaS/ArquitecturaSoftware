package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "PHONE")
@IdClass(PhonePK.class)
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @EqualsAndHashCode.Include
    @Embedded
    private PhonePK phonePk;
    @Column(name = "TYPE", nullable = false)
    private String type;

    public Phone(PhonePK phonePk) {
        this.phonePk = phonePk;
    }

    public PhonePK getPhonePk() {
        return phonePk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}