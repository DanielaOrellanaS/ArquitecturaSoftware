package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.banquito.corepasivos.product.model.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@Entity
@Table(name = "segment")
public class Segment implements Serializable {

    @Id
    @Include
    @Column(name = "code_segment", length = 16, nullable = false)
    private String codeSegment;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @JsonManagedReference
    @OneToMany(mappedBy = "segment")
    private List<Product> products;

    @JsonManagedReference
    @OneToMany(mappedBy = "segment", fetch = FetchType.LAZY)
    private List<Client> clients;

    public Segment(String codeSegment) {
        this.codeSegment = codeSegment;
    }

}
