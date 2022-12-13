package com.banquito.corepasivos.general.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public List<Holiday> findAll() {
        return this.holidayRepository.findAll();
    }

    public List<Holiday> findDateBetweenYear(Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 1);
        Date dateBefore = calendar.getTime();
        calendar.set(year, 11, 31);
        Date dateAfter = calendar.getTime();
        return this.holidayRepository.findByDateBetween(dateBefore,dateAfter);
    }
    public List<Holiday> findDateBetweenMonthAndYear(Integer month,Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1,1);
        Date dateBefore = calendar.getTime();
        calendar.set(year, month,1);
        Date dateAfter = calendar.getTime();
        return this.holidayRepository.findByDateBetween(dateBefore,dateAfter);

    }

    public List<Holiday> findByType(String type) {
        try {
            return this.holidayRepository.findByType(type);
        } catch (Exception e) {
            throw new RuntimeException("The Holiday by type does not exist");
        }
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
    public void updateByDate(String dateHoliday, Holiday holiday) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date newDate = dateFormat.parse(dateHoliday);
        Optional<Holiday> optional = this.holidayRepository.findById(newDate);
        if(optional.isPresent()){
            this.holidayRepository.save(holiday);
        } else {
            throw new RuntimeException("Not found");
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

    @Transactional
    public void deleteByDate(String dateHoliday) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            Date newDate = dateFormat.parse(dateHoliday);
            // this.holidayRepository.findById(newDate);
            this.holidayRepository.deleteById(newDate);
        } catch (Exception e) {
            throw new RuntimeException("The Holiday does not exist");
        }
    }

    public void generateHolidayByYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 1);
        Date date = calendar.getTime();
        Date sunday;
        Date saturday;
        while (!(isDay(date, "sábado") || isDay(date, "domingo"))) {
            date = addDaysToDate(date, 1);
            System.out.println(date);
        }

        if (isDay(date, "sábado")) {
            sunday = date;
            saturday = addDaysToDate(date, 1);
        } else {

            Holiday holiday = new Holiday();
            holiday.setDate(date);
            holiday.setCodeLocation(17);
            holiday.setName("Weekend Holiday");
            holiday.setType("NAT");
            create(holiday);

            sunday = addDaysToDate(date, 6);
            saturday = addDaysToDate(date, 7);
        }

        String yearHoliday;
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");

        do {
            yearHoliday = getYearFormat.format(sunday);
            if (Integer.parseInt(yearHoliday) <= year) {
                Holiday sundayHoliday = new Holiday();
                sundayHoliday.setDate(sunday);
                sundayHoliday.setCodeLocation(17);
                sundayHoliday.setName("Weekend Holiday");
                sundayHoliday.setType("NAT");
                create(sundayHoliday);
            }

            yearHoliday = getYearFormat.format(saturday);
            if (Integer.parseInt(yearHoliday) <= year) {
                Holiday saturdayHoliday = new Holiday();
                saturdayHoliday.setDate(saturday);
                saturdayHoliday.setCodeLocation(17);
                saturdayHoliday.setName("Weekend Holiday");
                saturdayHoliday.setType("NAT");
                create(saturdayHoliday);
            }

            sunday = addDaysToDate(sunday, 7);
            saturday = addDaysToDate(saturday, 7);

        } while (Integer.parseInt(yearHoliday) <= year);

    }

    private Date addDaysToDate(Date date, int dias) {
        if (dias == 0)
            return date;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    private boolean isDay(Date date, String day) {
        String dateString;
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE yyy-MM-dd");
        dateString = dateFormat.format(date);
        System.out.println(dateString);
        return dateString.indexOf(day) >= 0;
    }

}
