package com.hyman.common.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.hyman.common.model.dto.common.DateDto;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.time.*;
import java.util.*;

/**
 * @author hyman
 * @description: 日期转换工具
 * @createTime: 2020/8/27
 */
public class DateTransUtil {

    public static Date getOFFHour(Date time, int offset) {
        return DateUtil.offsetHour(time, offset);
    }

    /**
     * description: 给定一个日期获取该日期周一的00:00:00
     * param: []
     * return: java.util.Date
     * author  hyman
     * createTime: 2020/8/27
     */
    public static Date getWeekStartTime(Date time) {
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);
        cld.setTimeInMillis(time.getTime());
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return DateUtil.beginOfDay(cld.getTime());
    }

    /**
     * description: 给定一个日期获取该日期周日的23:59:59
     * param: []
     * return: java.util.Date
     * author  hyman
     * createTime: 2020/8/27
     */
    public static Date getWeekEndTime(Date time) {
        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setFirstDayOfWeek(Calendar.MONDAY);
        cld.setTimeInMillis(time.getTime());
        cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return DateUtil.endOfDay(cld.getTime());
    }

    /**
     * description: 获取传入时间的周几,
     * param: [time]
     * return: int 1~7
     * author  hyman
     * createTime: 2020/8/27
     */
    public static int getWeekNum(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int weekNum = c.get(Calendar.DAY_OF_WEEK) - 1;
        return weekNum == 0 ? 7 : weekNum;
    }

    /**
     * 在指定日期上加n天
     *
     * @param date 指定日期
     * @param days 天数
     * @return 计算后的日期
     */
    public static Date addDays(@NotNull Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 在指定日期上减去n天
     *
     * @param date 指定日期
     * @param days 天数
     * @return 计算后的日期
     */
    public static Date subtractDays(@NotNull Date date, int days) {
        return addDays(date, days * -1);
    }

    /**
     * 给定年份，月份获取某年某月的开始时间
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getBeginTimeByYearAndMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }


    /**
     * 给定指定日期和天数，返回指定日期当月的第n天，时分秒为0
     *
     * @param date 指定日期
     * @param day  指定天数
     * @return 指定日期当月的第n天
     */
    public static Date getSpecifiedDay(@NotNull Date date, int day) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);

        instance.set(Calendar.DAY_OF_YEAR, day);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);

        return instance.getTime();
    }

    /**
     * 给定指定日期和天数，返回指定日期下个月的第n天，时分秒为0
     *
     * @param date 指定日期
     * @param day  指定天数
     * @return 指定日期下个月的第n天
     */
    public static Date getSpecifiedDayOfNextMonth(@NotNull Date date, int day) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);

        instance.add(Calendar.MONTH, 1);
        instance.set(Calendar.DAY_OF_MONTH, day);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);

        return instance.getTime();
    }

    /**
     * 获取从给定时间到今天为止，每周的开始和结束时间，包括给定时间所在的那周和今天所在的这周。
     * 开始时间：每周一的0点
     * 结束时间：每周日的23点59分59秒（不带毫秒）
     *
     * @param specifiedTime 开始时间
     * @return 从给定时间到今天为止，每周的开始和结束时间
     */
    public static List<DateDto> getStartAndEndDateOfEveryWeekSinceGivenDate(@Nonnull Date specifiedTime) {

        //给定时间的那周一
        DateTime startDate = DateUtil.beginOfWeek(specifiedTime);
        //今天所在的这周的下周一
        DateTime endDate = DateUtil.beginOfWeek(new Date()).offset(DateField.DAY_OF_YEAR, 7);
        List<DateDto> list = new ArrayList<>();
        //从给定时间到今天这周的每周的开始和结束时间
        while (startDate.before(endDate)) {
            list.add(new DateDto(DateUtil.beginOfWeek(startDate), new DateTime(DateUtil.truncate(DateUtil.endOfWeek(DateUtil.calendar(startDate)), DateField.SECOND))));
            startDate = startDate.offset(DateField.DAY_OF_YEAR, 7);
        }
        return list;
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime,
                                         Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 时间处理方法  传入秒 转换为时分秒
     * @param time
     * @return x时x分x秒
     */
    public static String secToTime(int time) {
        String timeStr;
        int hour;
        int minute;
        int second;
        if (time <= 0) {
            return "0秒";
        } else if (time < 60){
            return time + "秒";
        } else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = minute + "分" + second + "秒";
            } else {
                hour = minute / 60;
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = hour + "时" + minute + "分" + second + "秒";
            }
        }
        return timeStr;
    }

}
