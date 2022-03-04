package com.lendTech.digiLend.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DatesHelper {

    private final ZoneId zoneId = ZoneId.of("Africa/Nairobi");

    public String currentDateTime() {

        LocalDateTime now = LocalDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    public String addOneMonthToDate(String date) throws ParseException {
        String[] s = date.split(" ");
        return LocalDate.parse(s[0]).plusMonths(1).toString() + " " + s[1];
    }

}