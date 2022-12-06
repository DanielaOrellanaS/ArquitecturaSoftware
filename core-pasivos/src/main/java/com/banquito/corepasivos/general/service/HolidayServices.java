package com.banquito.corepasivos.general.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.banquito.corepasivos.general.model.Holiday;
import com.banquito.corepasivos.general.repository.HolidayRepository;

@Service
public class HolidayServices {
    private final HolidayRepository holidayRepository;

    public HolidayServices(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Transactional
    public void create(Holiday holiday) {
        List<Holiday> holidays = this.holidayRepository.findByCodeLocation(holiday.getCodeLocation());
        if (holidays.isEmpty()) {
            this.holidayRepository.save(holiday);
        } else {
            throw new RuntimeException("The Country Entity already exists");
        }
    }

    @Transactional
    public void update(Holiday holiday) {
        List<Holiday> holidays = this.holidayRepository.findByCodeLocation(holiday.getCodeLocation());
        if (!holidays.isEmpty() && holidays.size() == 1) {
            this.holidayRepository.save(holiday);
        } else {
            throw new RuntimeException("An error has occurred in the product update");
        }
    }

    @Transactional
    public void delete(Holiday holiday) {
        List<Holiday> holidays = this.holidayRepository.findByCodeLocation(holiday.getCodeLocation());
        if (!holidays.isEmpty()) {
            this.holidayRepository.delete(holiday);
        } else {
            throw new RuntimeException("The Country Entity does not exist");
        }
    }

    public List<Holiday> findAll() {
        return this.holidayRepository.findAll();
    }

}
