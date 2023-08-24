package com.dykj.webApi.utils;



import com.dykj.webApi.constant.DateContant;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:ctj
 * @date:2023/6/2
 * @Description:日期工具类
 */
public class DateUtil extends PropertyEditorSupport{
    static final String patternOrderNum="yyyyMMddHHmm";

    public static final DateFormat DF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat DF_YEAR = new SimpleDateFormat("yyyy");
    public static final DateFormat DF_MONTH = new SimpleDateFormat("yyyy-MM");
    /**
     * 短类型日期长度
     */
    public static final int SHORT_DATE = 10;

    public static final int YEAR_DATE = 4;

    public static final int MONTH_DATE = 7;

    /**
     * 获取年
     * @param date
     * @return
     */
    public static Integer getYearByDateTime(Date date){
        SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("YYYY");
        String year = simpleDateFormatYear.format(date);
        Integer yearInt = Integer.valueOf(year);
        return yearInt;
    }

    /**
     * 获取月份
     * @param date
     * @return
     */
    public static Integer getMonthByDateTime(Date date){
        SimpleDateFormat simpleDateFormatYear = new SimpleDateFormat("MM");
        String month = simpleDateFormatYear.format(date);
        //去除月份前的0
        month = month.replaceFirst("^0+(?!$)", "");
        Integer monthInt = Integer.valueOf(month);
        return monthInt;
    }

    /**
     * 获取日
     * @param date
     * @return
     */
    public static Integer getDayByDateTime(Date date){
        SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("dd");
        String day = simpleDateFormatDay.format(date);
        Integer dayInt = Integer.valueOf(day);
        return dayInt;
    }

    /**
     * 获取小时
     * @param date
     * @return
     */
    public static Integer getHourByDateTime(Date date){
        SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("HH");
        String hour = simpleDateFormatHour.format(date);
        Integer hourInt = Integer.valueOf(hour);
        return hourInt;
    }

    /**
     * 获取分钟
     * @param date
     * @return
     */
    public static Integer getMinuteByDateTime(Date date) {
        SimpleDateFormat simpleDateFormatMinute = new SimpleDateFormat("mm");
        String minute = simpleDateFormatMinute.format(date);
        Integer minuteInt = Integer.valueOf(minute);
        return minuteInt;
    }

    /**
     * 获取星期
     * 英文版
     * @param weekInt
     * @return
     */
    public static String getWeekEN(Integer weekInt) {

        String dayOfWeek = "";
        
        if (weekInt == DateContant.MONDAY){
            dayOfWeek = "MON";
        }
        if (weekInt == DateContant.TUESDAY){
            dayOfWeek = "TUE";
        }
        if (weekInt == DateContant.WEDNESDAY){
            dayOfWeek = "WED";
        }
        if (weekInt == DateContant.THURSDAY){
            dayOfWeek = "THU";
        }
        if (weekInt == DateContant.FRIDAY){
            dayOfWeek = "FRI";
        }
        if (weekInt == DateContant.SATURDAY){
            dayOfWeek = "SAT";
        }
        if (weekInt == DateContant.SUNDAY){
            dayOfWeek = "SUN";
        }
        return dayOfWeek;
    }

    /**
     * 获取星期
     * 中文版
     * @param weekInt
     * @return
     */
    public static String getWeekCHN(Integer weekInt) {

        String dayOfWeek = "";

        if (weekInt == DateContant.MONDAY){
            dayOfWeek = "星期一";
        }
        if (weekInt == DateContant.TUESDAY){
            dayOfWeek = "星期二";
        }
        if (weekInt == DateContant.WEDNESDAY){
            dayOfWeek = "星期三";
        }
        if (weekInt == DateContant.THURSDAY){
            dayOfWeek = "星期四";
        }
        if (weekInt == DateContant.FRIDAY){
            dayOfWeek = "星期五";
        }
        if (weekInt == DateContant.SATURDAY){
            dayOfWeek = "星期六";
        }
        if (weekInt == DateContant.SUNDAY){
            dayOfWeek = "星期日";
        }
        return dayOfWeek;
    }
    /**
     * 获得当前日期的时间流水号
     * 到分钟
     * @return
     */
    public static String getDateOrderNum(){
        DateTime date=new DateTime();
        return date.toString(patternOrderNum);
    }

    /**
     * 时间戳转为String格式时间
     * 格式 yyyy-MM-dd HH:mm:ss
     * @param num
     * @return
     */
    public static String longToDate(Long num){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(num);
        String dateStr = sdf.format(date);
        return dateStr;

    }

    /**
     * 将date转为String
     * @param date
     * @return String
     */
    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 获取时分秒
     * @param date
     * @return String
     */
    public static String getHourAndMinuteAndSecond(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }



}
