package com.banquito.corepasivos.general.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Date> {
    /*
     * List<Holiday> findByHolidayDateBetween(Date initDate, Date lastDate);
     * 
     * List<Holiday> findByCodeLocation(Integer codeLocation);
     */
}
