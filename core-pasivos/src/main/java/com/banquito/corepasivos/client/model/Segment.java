package com.banquito.corepasivos.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.banquito.corepasivos.product.model.Product;

@Data
@NoArgsConstructor
@Entity
@Table(name = "segment")
public class Segment {

    @Id
    @Include
    @Column(name = "code_segment", length = 16, nullable = false)
    private String codeSegment;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "status", length = 3, nullable = false)
    private String status;

    @OneToMany(mappedBy = "segment", targetEntity = Product.class)
    private List<Product> products;

    @OneToMany(mappedBy = "segment", targetEntity = Client.class)
    private List<Client> clients;

    public Segment(String codeSegment) {
        this.codeSegment = codeSegment;
    }

}
