package com.banquito.corepasivos.client.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientAddressPK{
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_CLIENT", nullable = false)
    private Integer codeClient; 
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "CODE_LOCATION", nullable = false)
    private Integer codeLocation;    
}
