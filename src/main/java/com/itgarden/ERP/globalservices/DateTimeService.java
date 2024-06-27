/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.globalservices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DateTimeService {

    public Date currentDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        Date newDate = dformat.parse(formatter.format(date));

        return newDate;

    }

    public LocalDate localCurrentDate() throws ParseException {
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Dhaka"));

        String dformat = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate nlocalDate = LocalDate.parse(dformat);

        return nlocalDate;
    }

    public LocalDate getCurrentMonthDayOne() throws ParseException {
        LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Dhaka"));

        String dformat = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate nlocalDate = LocalDate.parse(dformat);

        return nlocalDate;
    }

    public LocalDate getCurrentMonthDayLast() throws ParseException {
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Dhaka"));

        String dformat = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate nlocalDate = LocalDate.parse(dformat);

        return nlocalDate;
    }

}
