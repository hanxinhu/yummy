package edu.nju.hxh.yummy.util;

import lombok.Data;

import java.util.Calendar;

/**
 * @author hxh
 * @date 2019-03-10 10:04
 */
@Data
public class TimeUtil {
    private int year;
    private int month;
    private int day;

    public TimeUtil() {
        Calendar calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DATE);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public TimeUtil(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public TimeUtil(String date) {
        String[] param = date.split("-");
        year = Integer.parseInt(param[0]);
        month = Integer.parseInt(param[1]);
        day = Integer.parseInt(param[2]);
    }


    @Override
    public String toString() {
        return String.format("%4d-%02d-%02d", year, month, day);
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return String.format("%4d-%02d-%02d", year, month, day);
    }

    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return getDate() + String.format(" %02d:%02d:%02d", hour, minute, second);
    }
}
