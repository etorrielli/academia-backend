/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.undec.academia.util;

import com.undec.academia.model.Role;
import com.undec.academia.model.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

/**
 * @author etorrielli
 */
public class Utils {


    private static LocalDate nextOrSameWorkingDay(LocalDate date) {
        return isWeekEnd(date) ? nextWorkingDay(date, 1) : date;
    }

    private static LocalDate nextWorkingDay(LocalDate date, int step) {
        do {
            date = date.plusDays(step);
        } while (isWeekEnd(date));
        return date;
    }

    private static boolean isWeekEnd(LocalDate date) {
        DayOfWeek dow = date.getDayOfWeek();
        return dow == SATURDAY || dow == SUNDAY;
    }

    public static String getYear() {
        LocalDate localDate = LocalDate.now(ZoneId.of("UTC-03:00"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }

    public static long getYearsBetween(Date fecha1, Date fecha2) {
        LocalDate start = Instant.ofEpochMilli(fecha1.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate stop = LocalDate.now(ZoneId.systemDefault());
        long years = java.time.temporal.ChronoUnit.YEARS.between(start, stop);
        return years;
    }

    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date localDateToDate(LocalDate local) {
        Instant instant = Instant.from(local.atStartOfDay(ZoneId.of("UTC-03:00")));
        return Date.from(instant);
    }

    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static TemporalAdjuster addWorkingDays(long workingDays) {
        return TemporalAdjusters.ofDateAdjuster(d -> addWorkingDays(d, workingDays));
    }

    public static LocalDate addWorkingDays(LocalDate startingDate, long workingDays) {
        if (workingDays == 0) return nextOrSameWorkingDay(startingDate);

        LocalDate result = startingDate;
        int step = Long.signum(workingDays); //are we going forward or backward?

        for (long i = 0; i < Math.abs(workingDays); i++) {
            result = nextWorkingDay(result, step);
        }

        return result;
    }

    public static Integer getWorkingDays(Date startingDate, boolean complete) {
        Date lastDay = getLastDateOfMonth(startingDate);
        LocalDate lastDayLocale = dateToLocalDate(lastDay);
        Date firstDay;
        if (complete) {
            firstDay = getFirstDateOfMonth(startingDate);
        } else {
            firstDay = startingDate;
        }
        LocalDate firstDayLocale = dateToLocalDate(firstDay);
        Integer dayCounter = 0;
        LocalDate addDay = firstDayLocale;
        do {
            addDay = addWorkingDays(addDay, 1);
            dayCounter++;
        }
        while (addDay.isBefore(lastDayLocale) || addDay.isEqual(lastDayLocale));

        return dayCounter;
    }

    public static String getLoggedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = "sin datos";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return currentUserName;
    }

    public static String getFormattedDate(LocalDate input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return formatter.format(input);
    }

    public static String getFormattedDate(Date input) {
        String DATE_FORMAT = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(input);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static boolean isRolAdmin(User userDetails) {
        for (Role grantedAuthority : userDetails.getRoles()) {
            if (grantedAuthority.getName().name().equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }

    public static String pad(Integer number, Integer length) {
        String str = "" + number;
        while (str.length() < length) {
            str = "0" + str;
        }
        return str;
    }

    public static float hoursBetween(String time1, String time2) {
        String[] splitTime1;
        String[] splitTime2;
        /* delimiter */
        String delimiter = ":";
        splitTime1 = time1.split(delimiter);
        splitTime2 = time2.split(delimiter);
        int minutes = Integer.valueOf(splitTime2[1]) - Integer.valueOf(splitTime1[1]);
        int hours = Integer.valueOf(splitTime2[0]) - Integer.valueOf(splitTime1[0]);
        if (minutes < 0) {
            hours--;
        }
        minutes = Math.abs(minutes);
        float minutesHours = minutes / 60f;
        float total = hours + minutesHours;
        return total;
    }

    public static Date stringToDate(String date) {
        String year = date.substring(4, 8);
        String month = date.substring(2, 4);
        String day = date.substring(0, 2);
        LocalDate localDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        return localDateToDate(localDate);
    }

    public static int getDiaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

}
