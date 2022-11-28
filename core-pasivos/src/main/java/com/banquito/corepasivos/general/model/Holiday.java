package com.banquito.corepasivos.general.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "holiday")
@Data
@NoArgsConstructor
public class Holiday {

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "holiday_date", nullable = false)
    private Date date;

    @Column(name = "code_location", nullable = true)
    private Integer codeLocation;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "type", length = 3, nullable = false)
    private String type;
    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "code_location", referencedColumnName = "code_location",
     * insertable = false, updatable = false, nullable = true)
     * private LocationEntity locationEntity;
     */

    public Holiday(Date date) {
        this.date = date;
    }
}
