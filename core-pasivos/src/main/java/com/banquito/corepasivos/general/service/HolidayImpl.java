package com.banquito.corepasivos.general.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banquito.corepasivos.general.model.Holiday;
import com.banquito.corepasivos.general.repository.HolidayRepository;

public class HolidayImpl implements HolidayService {
    @Autowired
    HolidayRepository holidayRepository;

    @Override
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }
}
