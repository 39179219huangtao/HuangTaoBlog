package com.yijiupi.bi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangyuansheng
 * @date 2018/3/30
 * Modified by huangyuansheng 2018/4/3:修改为线程安全的时间格式转换类
 */
public class DateUtils {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss" +
            ".SSS";

    public static final String YYYY_MM_DD_HH = "yyyyMMddHH";

    public static final String YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";

    public static final String YYYY_MM_DD = "yyyyMMdd";

    /**
     * 锁对象
     */
    private static final Object lockObj = new Object();

    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = ThreadLocal.withInitial(() -> new SimpleDateFormat(pattern));
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * 是用ThreadLocal<SimpleDateFormat>来获取SimpleDateFormat,这样每个线程只会有一个SimpleDateFormat
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String transDateToString(Date date, String pattern) {
        if (null == date) {
            return " ";
        }
        return getSdf(pattern).format(date);
    }

    public static String transSqlDateToString(java.sql.Date date,
                                              String pattern) {
        return transDateToString(new Date(date.getTime()), pattern);
    }

    public static Date tranSqlDateToUtilDate(java.sql.Date date) {
        return new Date(date.getTime());
    }


    public static Date parseDateStringToDate(String dateStr, String pattern) {
        try {
            return getSdf(pattern).parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String parseTimeStampToDateString(Long ts, String pattern) {
        return getSdf(pattern).format(ts);
    }

    public static Date parseTimeStampToDate(Long ts, String pattern) {
        return parseDateStringToDate(parseTimeStampToDateString(ts, pattern), pattern);
    }

    public static Date changeStringToDate(String dateStr) {
        return parseDateStringToDate(dateStr, YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * 比较日期
     *
     * @param newDate
     * @param oldDate
     * @return
     */
    public static boolean compareDate(Date newDate, Date oldDate) {
        if (newDate == null && oldDate == null) {
            return false;
        } else {
            if (newDate != null) {
                if (oldDate == null) {
                    return true;
                } else {
                    return newDate.after(oldDate);
                }
            } else {
                return false;
            }
        }
    }
}
