package com.banquito.corepasivos.general.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        List<Holiday> holidays = this.holidayRepository.findByDate(holiday.getDate());
        if (holidays.isEmpty()) {
            this.holidayRepository.save(holiday);
        } else {
            throw new RuntimeException("The Holiday already exists");
        }
    }

    @Transactional
    public void update(Holiday holiday) {
        List<Holiday> holidays = this.holidayRepository.findByDate(holiday.getDate());

        if (!holidays.isEmpty()) {
            this.holidayRepository.save(holiday);
        } else {
            throw new RuntimeException("An error has occurred in the Holiday update");
        }
    }

    @Transactional
    public void delete(Holiday holiday) {
        List<Holiday> holidays = this.holidayRepository.findByDate(holiday.getDate());

        if (!holidays.isEmpty()) {
            this.holidayRepository.delete(holiday);
        } else {
            throw new RuntimeException("The Holiday does not exist");
        }
    }

    public List<Holiday> findAll() {
        return this.holidayRepository.findAll();
    }

    public Optional<Holiday> findById(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            Date newDate = dateFormat.parse(date);
            return this.holidayRepository.findById(newDate);
        } catch (Exception e) {
            throw new RuntimeException("The Holiday does not exist");
        }
        
    }

}
