package com.banquito.corepasivos.general.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "holiday")
public class Holiday {

    @Id
    @Include
    @Temporal(TemporalType.DATE)
    @Column(name = "holiday_date", nullable = false)
    private Date date;

    @Column(name = "code_location", nullable = false)
    private Integer codeLocation;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "type", length = 3, nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "code_location", referencedColumnName = "code_location", insertable = false, updatable = false)
    private LocationEntity locationEntity;

    public Holiday(Date date) {
        this.date = date;
    }

    public boolean validateWeekend(Date dateHoliday){
        int saturday, sunday; 
        String formattedDate; 
        Date initDate = dateHoliday;

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE yyyy-MM-dd");
        formattedDate = dateFormat.format(initDate);

        saturday = formattedDate.indexOf("sabado");
        sunday = formattedDate.indexOf("domingo");
        if((saturday>=0) || (sunday>=0)){
            return true;
        } else {
            return false;
        }
    }

}
