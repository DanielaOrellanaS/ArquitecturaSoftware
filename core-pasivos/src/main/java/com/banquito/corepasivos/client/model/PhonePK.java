package com.banquito.corepasivos.client.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class PhonePK implements Serializable {

    @Column(name = "PHONE_NUMBER", length = 16, nullable = false)
    private String phoneNumber;
    @Column(name = "CODE_CLIENT", length = 4, nullable = false)
    private Integer codeClient;
}
