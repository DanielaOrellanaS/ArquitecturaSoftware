package com.banquito.corepasivos.general.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.corepasivos.general.model.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Date> {

}
