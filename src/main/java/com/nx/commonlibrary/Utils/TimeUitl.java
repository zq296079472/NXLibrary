package com.nx.commonlibrary.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhnagqiang
 * 时间操作工具类
 */
public class TimeUitl {

    private Long mTime = System.currentTimeMillis();//默认为当前系统时间

    private Calendar calendar;


    public TimeUitl() {
        initCalender();
    }

    public TimeUitl(Long time) {
        this.mTime = time;
        initCalender();
    }


    //初始化calendar
    private void initCalender() {
        calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
    }

    /**
     * 获取当前设置时间多少天以前（之后）的时间
     *
     * @param beforeDay 正整数多少天之前 负整数为多少天之后
     * @return long时间
     */
    public Long getBeforeDay(int beforeDay) {
        resetTime();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - beforeDay);
        return calendar.getTimeInMillis();
    }

    /**
     * 返回昨天的 00:00:00的时间
     *
     * @return 昨天
     */
    public Long getYesterday() {
        return getBeforeDay(1);
    }

    /**
     * 获取本周第一天的时间
     *
     * @return 本周第一天时间 00:00:00
     */
    public Long getMonday() {
        resetTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取本周的周日的时间
     *
     * @return
     */
    public Long getSunday() {
        resetTime();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取本周周日的时间(多一毫秒就是下周一)
     *
     * @return ...23:59:59:59
     */
    public Long getEndDayOfWeek() {
        calendar.setTimeInMillis(this.mTime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当前时间是周几
     * 1：星期一
     * 7：星期日
     *
     * @return int：1-7
     */
    public int getDayOfWeek() {
        resetTime();
        return calendar.get(Calendar.DAY_OF_WEEK) + 1;
    }

    /**
     * 获取当前时间是星期几
     *
     * @return 星期一-星期日
     */
    public String getStrDayOfWeek() {
        resetTime();
        String dayOfWeek = null;
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                dayOfWeek = "星期一";
                break;
            case Calendar.TUESDAY:
                dayOfWeek = "星期二";
                break;
            case Calendar.WEDNESDAY:
                dayOfWeek = "星期三";
                break;
            case Calendar.THURSDAY:
                dayOfWeek = "星期四";
                break;
            case Calendar.FRIDAY:
                dayOfWeek = "星期五";
                break;
            case Calendar.SATURDAY:
                dayOfWeek = "星期六";
                break;
            case Calendar.SUNDAY:
                dayOfWeek = "星期日";
                break;
        }
        return dayOfWeek;
    }

    /**
     * 获取今天的开始的时间
     *
     * @return
     */
    public Long getFirstTimeOfDay() {
        resetTime();
        return calendar.getTimeInMillis();
    }


    /**
     * 获取上午或下午
     * @param time
     * @return
     */
    public String getAMPM(Long time) {
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.AM_PM) == 0 ? "上午" : "下午";
    }

    /**
     * 12小时时间显示
     * @param time
     * @return
     */
    public String get12HoreTime(Long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        return getAMPM(time) + simpleDateFormat.format(new Date(time));
    }


    /**
     * 获取今天结束的时间
     *
     * @return
     */
    public Long getEndTimeOfDay() {
        calendar.setTimeInMillis(this.mTime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        return calendar.getTimeInMillis();
    }


    //重置时间
    private void resetTime() {
        calendar.setTimeInMillis(this.mTime);
        resetHMS();
    }

    //置零小时分钟秒毫秒
    private void resetHMS() {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static String getDayStr(String time) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }


}
