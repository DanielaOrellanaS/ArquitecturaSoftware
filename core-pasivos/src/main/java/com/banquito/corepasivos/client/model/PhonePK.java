package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhonePK {

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;
}
