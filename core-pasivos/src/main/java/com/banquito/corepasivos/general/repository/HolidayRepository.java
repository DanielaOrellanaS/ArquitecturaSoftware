package com.banquito.corepasivos.general.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.corepasivos.general.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Date> {
    List<Holiday> findByDate(Date date);

    List<Holiday> findByCodeLocation(Integer codeLocation);

    List<Holiday> findAll();

}
