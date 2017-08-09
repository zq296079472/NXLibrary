package com.nx.commonlibrary.Utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 操作日期工具类
 * Created by liqinghua on 2015-07-28 上午10:59.
 */
public class DateUtil {

    /**
     * 获得当前的时间
     *
     * @return Date
     */
    public static java.util.Date getDateNow() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    /**
     * 获得当前月1号0点0分0秒
     *
     * @return
     */
    public static java.util.Date initFirstDayOfM() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);

        return cal.getTime();
    }

    /**
     * 获得当前月最后一天时间
     * @return
     */
    public static java.util.Date initLastDayOfM() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
        cal.add(Calendar.SECOND, -1);
        return cal.getTime();
    }

    /**
     * 将字符串转换为日期。如果不合法，返回 NULL
     *
     * @param strDate 字符串日期。格式为 "yyyy-MM-dd" 。
     * @return Date
     */
    public static java.util.Date convertStrToDate(String strDate) {
        if (!strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        try {
            cal.set(Calendar.YEAR, Integer.parseInt(strDate.split("-")[0]));//提取时间字符串的年赋值在setcal中去
            cal
                    .set(Calendar.MONTH, Integer
                            .parseInt(strDate.split("-")[1]) - 1);//同理获取月赋值
            cal.set(Calendar.DATE, Integer.parseInt(strDate.split("-")[2]));//同理获取日赋值
            return cal.getTime();//cal得到传递过来的年月日返回
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 检查字符串是否符合日期格式
     *
     * @param strDate 需要check的日期
     * @return 日期是否合法
     */
    public static boolean isDateFormatValid(String strDate) {
        java.util.Date date = convertStrToDate(strDate);
        return (date != null);
    }

    /**
     * 将时间格式化为 年月日 形式。例如 20000101
     *
     * @param date 时间
     * @return String
     */
    public static String formatDateNum(java.util.Date date) {
        DateFormat fdDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            return fdDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将时间格式化为 年-月-日 形式。例如 2000-01-01
     *
     * @param date 时间
     * @return String
     */
    public static String formatDate(java.util.Date date) {
        DateFormat fdDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fdDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将时间格式化为 小时:分钟;秒 形式。例如 19:06:01
     *
     * @param dDate 时间
     * @return String
     */
    public static String formatTime(java.util.Date dDate) {
        DateFormat fdDateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return fdDateFormat.format(dDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将时间格式化为 小时:分钟;秒 形式。例如 19:06:01
     *
     * @param dDate 时间
     * @return String
     */
    public static String formatTimeDate(java.util.Date dDate) {
        DateFormat fdDateFormat = new SimpleDateFormat("HH:mm");
        try {
            return fdDateFormat.format(dDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将时间格式化为 年-月-日 小时:分钟;秒 形式。例如 2001-01-01 19:06:01
     *
     * @param dDate 时间
     * @return String
     */
    public static String formatDateTime(java.util.Date dDate) {
        if (dDate == null) {
            return "";
        }
        DateFormat fdDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return fdDateFormat.format(dDate);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 将事件格式化为 年－月－日 时：分：秒 形式  例如 2001-01-01 19:06:01
     *
     * @param datetime long
     * @return
     */
    public static String formatDateTime(Long datetime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(datetime);
        return formatDateTime(calendar.getTime());
    }

    /**
     * 以指定的格式来格式化日期
     *
     * @param date
     * @param format
     * @return String
     */
    public static String formatDateByFormat(java.util.Date date, String format) {
        if (date != null) {
            try {
                DateFormat sdf = new SimpleDateFormat(format);
                return sdf.format(date);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }

    /**
     * 返回给定年份的最后一天 "2014-12-31 23:59:59"
     *
     * @param nYear
     * @return
     */
    public static String getLastDateOfYear(int nYear) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, nYear + 1);
            cal.add(Calendar.DAY_OF_YEAR, -1);
            return DateUtil.formatDate(cal.getTime()) + " 23:59:59";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回给定月份的最后一天
     *
     * @param nYear
     * @param nMonth
     * @return Date
     */
    public static java.util.Date getLastDateOfMonth(int nYear, int nMonth) {
        try {
            Calendar cal = Calendar.getInstance();
            nMonth++;
            if (nMonth >= 12) {
                nYear++;
                nMonth = 0;
            }
            cal.set(nYear, nMonth, 1);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            return cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回给定年份的第一天 "2014-01-01 00:00:00"
     *
     * @param nYear
     * @return
     */
    public static String getFirstDateOfYear(int nYear) {
        return nYear + "-01-01 00:00:00";
    }

    /**
     *  返回给定月份的最后一天 字符串
     * @param date
     * @param format      返回字符串的格式
     * @return string
     */
    public static String getLastDateOfMonth(java.util.Date date, String format) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.roll(Calendar.DAY_OF_MONTH, -1);
            return formatDateByFormat(cal.getTime(), format);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 返回给定月份的下一个月份的第一天
     *
     * @param  nYear
     * @param  nMonth
     * @return Date
     */
    public static java.util.Date getFirstDateOfNextMonth(int nYear, int nMonth) {
        try {
            Calendar cal = Calendar.getInstance();
            nMonth++;
            if (nMonth >= 12) {
                nYear++;
                nMonth = 0;
            }
            cal.set(nYear, nMonth, 1);
            return cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 返回中文星期名称
     *
     * @param date 日期
     * @return 中文星期名称
     */
    public static String getWeek(java.util.Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 当前日期前几天或者后几天的日期
     *
     * @param nDay 天数
     * @return date 日期
     */
    public static java.util.Date getDateAfterNDay(int nDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, nDay);
        java.util.Date date = cal.getTime();
        return date;
    }

    /**
     * 判断两个日期是否在同一周
     *
     * @param date1 日期
     * @param date2 日期
     * @return boolean
     */
    public static boolean isInSameWeek(java.util.Date date1,
                                       java.util.Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
                    .get(Calendar.WEEK_OF_YEAR)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 获得周一的日期
     *
     * @param date 日期
     * @return Date
     */
    public static java.util.Date getDateOfMonday(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获得周五的日期
     *
     * @param date 日期
     * @return Date
     */

    public static java.util.Date getDateOfFriday(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        return cal.getTime();
    }

    /**
     * 返回年份
     *
     * @param date 日期
     * @return 返回年份
     */
    public static int getDateInYear(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 返回月份
     *
     * @param date 日期
     * @return 返回月份
     */
    public static int getDateInMonth(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日
     *
     * @param date 日期
     * @return 返回日
     */
    public static int getDateInDay(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getDateInHour(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getDateInMinute(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getDateInSecond(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.SECOND);
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getDateInMillis(java.util.Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    /**
     * 日期相加
     *
     * @param date 日期
     * @param day  天数
     * @return 返回相加后的日期
     */
    public static java.util.Date getDateAfterDay(java.util.Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getDateInMillis(date) + ((long) day) * 24 * 3600
                * 1000);
        return cal.getTime();
    }

    /**
     * 日期相减
     *
     * @param date1 日期
     * @param date2 日期
     * @return 返回相减后的天数
     */
    public static int getDayDifference(java.util.Date date1,
                                       java.util.Date date2) {
        return (int) ((getDateInMillis(date1) - getDateInMillis(date2)) / (24 * 3600 * 1000));
    }

    /**
     * 将字符串转换为日期时间。如果不合法，返回 NULL
     *
     * @param strDate 字符串日期。格式为 "yyyy-MM-dd HH:mm:ss" 或者 "yyyy-MM-dd"。
     * @return Timestamp
     * @author Charlie
     */
    public static Timestamp StrToTimestamp(String strDate) {
        if (strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            strDate += " 00:00:00";
        } else if (strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
        } else {
            return null;
        }
        try {
            return Timestamp.valueOf(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将字符串转换为格式化日期时间。如果不合法，返回 NULL
     * @param strDate
     * @return
     */
    public static java.util.Date StrToDate(String strDate) {
        if (strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            strDate += " 00:00:00";
        } else if (strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
        } else {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date StrToSqlDate(String strDate) {
        if (strDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            try {
                return Date.valueOf(strDate);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowDateTime() {
        String now = formatDateTime(new java.util.Date(System.currentTimeMillis()));
        return now;
    }

    /**
     * 获取当天最后一秒的时间 电视退订业务中用到
     *
     * @return
     */
    public static Timestamp getCurrentDayLastTime() {
        String now = getNowDateTime();
        String nowDate = now.substring(0, now.indexOf(" "));
        return StrToTimestamp(nowDate + " 23:59:59");
    }

    /**
     * 获取当天的时间 电视订购业务中用到
     *
     * @return
     */
    public static Date getCurrentDaySQLDate() {
        String now = getNowDateTime();
        String nowDate = now.substring(0, now.indexOf(" "));
        return StrToSqlDate(nowDate);
    }

    /**
     * 获取 传入时间所在周的第一天 时间
     *
     * @param datetime 0L:当前时间  否则传入毫秒级时间long型数据
     * @return long   返回本周日00:00:00
     */
    public static Long getFirstDayInWeek(Long datetime) {

        Calendar calendar = Calendar.getInstance();
        if (datetime != 0L) {
            calendar.setTimeInMillis(datetime);
        }

        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取 传入时间所在周的最后一天 时间
     *
     * @param datetime 0L:当前时间  否则传入毫秒级时间long型数据
     * @return
     */
    public static Long getLastDayInWeek(Long datetime) {
        Calendar calendar = Calendar.getInstance();
        if (datetime != 0L) {
            calendar.setTimeInMillis(datetime);
        }

        calendar.setFirstDayOfWeek(Calendar.MONDAY);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTimeInMillis();
    }

    /**
     * 日期相加 相减
     *
     * @param date 日期
     * @param day  天数
     * @return 返回相加后的日期
     */
    public static Long getDateAfterDay(Long date, int day) {
        return date + day * 24 * 3600 * 1000L;
    }

    /**
     * 日期 加减月
     *
     * @param date
     * @param month
     * @return
     */
    public static Long getDateAfterMonth(Long date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + month);
        return c.getTimeInMillis();
    }

    public static void main(String[] args) {
        Long time = System.currentTimeMillis();
        System.out.println(time);
//
        Long d = DateUtil.getFirstDayInWeek(time + 3024000000L);
        System.out.println(DateUtil.formatDate(new Date(d)));

        Long f = DateUtil.getDateAfterDay(time, 5 * 7);
        System.out.println(DateUtil.formatDateTime(new Date(DateUtil.getFirstDayInWeek(f))));
        System.out.println(DateUtil.formatDateTime(new Date(DateUtil.getLastDayInWeek(DateUtil.getDateAfterDay(time, 5 * 7)))));

//		System.out.println(DateUtil.getLastDateOfMonth(2015,5));


//		System.out.println(DateUtil.getLastDateOfMonth(2015,5));

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(1438417159928L);
        System.out.println(c.getTime());


//		System.out.println(time);
//		Calendar c = Calendar.getInstance();
//		c.set(2015,11,31);
//		System.out.println(c.getTimeInMillis());
//
//		java.util.Date date = new java.util.Date(c.getTimeInMillis());
//		System.out.println(DateUtil.formatDateTime(date));
//
//		Long a = DateUtil.getLastDayInWeek(c.getTimeInMillis());
//		System.out.println(a);
//		java.util.Date date1 = new java.util.Date(a);
//		System.out.println(DateUtil.formatDateTime(date1));
//		System.out.println(a);
//		Calendar c = Calendar.getInstance();
//		System.out.println(c.getTimeInMillis());
    }
}
