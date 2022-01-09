package com.hyman.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: WuYangXu
 * @date: 2020/10/9
 */
public class DateDistance {

    /**
     * 两个时间之间相差距离多少天
     *
     * @param str1
     *            时间参数 1：
     * @param str2
     *            时间参数 2：
     * @return 相差天数
     */
    public static long getDistanceDays(String str1, String str2)
            throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date one;
        Date two;
        long days = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
}
