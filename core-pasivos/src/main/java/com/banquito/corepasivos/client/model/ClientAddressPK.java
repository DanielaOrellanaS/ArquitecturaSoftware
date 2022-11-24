package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ClientAddressPK{
    
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient;
    @Column(name = "CODE_LOCATION", nullable = false)
    private Integer codeLocation;    
}
