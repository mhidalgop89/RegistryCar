package com.registry.registrycar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.*;

public class Util {

    public String getLocalFormatEcDateToString(Date date){
        String resp = "";
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"/*,new Locale("es","EC")*/);
        sm.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        resp = sm.format(date);
        return resp;
    }

    public Date getLocalFormatEcDateToDate(String date) throws ParseException {
        Date resp = new Date();
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"/*,new Locale("es","EC")*/);
        sm.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        resp = sm.parse(date);
        return resp;
    }
    public Date earlyMorningLimit(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR, 4);

        return calendar.getTime();
    }
    public Date latestMorningLimit(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 10);

        return calendar.getTime();
    }

    public Date earlyAfterNoonLimit(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR, 15);

        return calendar.getTime();
    }
    public Date latestAfterNoonLimit(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 21);

        return calendar.getTime();
    }

    public Map<Integer , List<String>> getWeekValues(){
        Map<Integer , List<String>> weekValues = new HashMap<>();
        weekValues.put(MONDAY,List.of("1","2"));
        weekValues.put(TUESDAY,List.of("3","4"));
        weekValues.put(WEDNESDAY,List.of("5","6"));
        weekValues.put(THURSDAY,List.of("7","8"));
        weekValues.put(FRIDAY,List.of("9","0"));
        weekValues.put(SATURDAY,List.of("0","1","2","3","4","5","6","7","8","9"));
        weekValues.put(SUNDAY,List.of("0","1","2","3","4","5","6","7","8","9"));
        return weekValues;
    }

    public List<String> getAllowedPlatesByDay(Integer day){
        return getWeekValues().get(day);
    }

}
