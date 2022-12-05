package com.banquito.corepasivos.general.model;

import java.io.Serializable;
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

@Data
@NoArgsConstructor
@Entity
@Table(name = "holiday")
public class Holiday implements Serializable{

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

    @ManyToOne
    @JoinColumn(name = "CODE_LOCATION", nullable = false, insertable = false, updatable = false)
    private LocationEntity locationEntity;

    public Holiday(Date date) {
        this.date = date;
    }
}
