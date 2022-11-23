package com.banquito.corepasivos.geographic.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "HOLIDAY")
public class Holiday {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "CODE_LOCATION", nullable = true)
    private Integer codeLocation;
    @Column(name = "NAME", length = 64, nullable = false)
    private String name;
    @Column(name = "TYPE", length = 3, nullable = false)
    private String type;

    public Holiday(Date date){
        this.date=date;
    }
}