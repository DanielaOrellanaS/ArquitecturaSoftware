package com.banquito.corepasivos.general.model;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRANCH")
@Column(name = 'CODE_BRANCH')
@Data
@NoArgsConstructor
@EqualsAndHashCode.Include
public class Branch {
    private String code;
    private Integer codeLocation;
    private String name;

    public Branch(String code){
        this.code = code;
    }
}
