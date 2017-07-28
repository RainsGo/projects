package com.rainsgo.server.utils;

import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static Date generateDateByNow(){
        return new Date();
    }

    public static Timestamp generateTimestampByNow(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date toDate(String str, String format){
        if(StringUtils.isEmpty(format)){
            format = "yyyy/MM/dd HH:mm:ss";
        }
        try {
            return new SimpleDateFormat(format).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date toDate(Timestamp timestamp){
        return new Date(timestamp.getTime());
    }

    public static Timestamp toTimestamp(String str){
        return Timestamp.valueOf(str);
    }

    public static Timestamp toTimestamp(Date date){
        return new Timestamp(date.getTime());
    }

    public static String toString(Timestamp timestamp, String format){
        if(StringUtils.isEmpty(format)){
            format = "yyyy/MM/dd HH:mm:ss";
        }

        return new SimpleDateFormat(format).format(timestamp);
    }

    public static String toString(Date date, String format){
        if(StringUtils.isEmpty(format)){
            format = "yyyy/MM/dd HH:mm:ss";
        }

        return new SimpleDateFormat(format).format(date);
    }
}
