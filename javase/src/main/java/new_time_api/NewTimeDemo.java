package new_time_api;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author fullee
 *
 * 基本概念
 *
 * 时刻：所有计算机系统内部都用一个整数表示时刻，这个整数是距离格林尼治标准时间1970年1月1日0时0分0秒的毫秒数，可以理解时刻就是绝对时间，它与时区无关，不同时区对同一时刻的解读，即年月日时分秒是不一样的；
 *
 * 时区：同一时刻，世界上各个地区的时间可能是不一样的，具体时间与时区有关，一共有24个时区，英国格林尼治是0时区，北京是东八区，也就是说格林尼治凌晨1点，北京是早上9点；
 *
 * 年历：我们都知道，中国有公历和农历之分，公历和农历都是年历，不同的年历，一年有多少月，每月有多少天，甚至一天有多少小时，这些可能都是不一样的，我们主要讨论公历。
 *
 *
 *
 * Java 8中表示日期和时间的类有多个，主要的有：
 *
 * Instant：表示时刻，不直接对应年月日信息，需要通过时区转换
 *
 * LocalDateTime: 表示与时区无关的日期和时间信息，不直接对应时刻，需要通过时区转换
 *
 * LocalDate：表示与时区无关的日期，与LocalDateTime相比，只有日期信息，没有时间信息
 *
 * LocalTime：表示与时区无关的时间，与LocalDateTime相比，只有时间信息，没有日期信息
 *
 * ZonedDateTime： 表示特定时区的日期和时间
 *
 * ZoneId/ZoneOffset：表示时区
 */
public class NewTimeDemo {


    public static void main(String[] args) {

        String nowDateStr = LocalDate.now().toString();
        System.out.println(nowDateStr);//2018-03-27

        LocalDate nowDate = LocalDate.parse("2018-03-25");
        System.out.println(nowDate.toString());//2018-03-25


        String nowTimeStr = LocalTime.now().toString();
        System.out.println(nowTimeStr);//13:45:07.105

        LocalTime nowTime = LocalTime.parse("12:10:13");
        System.out.println(nowTime.toString());//12:10:13

        System.out.println(LocalDateTime.now().toString());//2018-03-27T13:55:34.047
        System.out.println(LocalDateTime.now().toLocalDate().toString());//2018-03-27
        System.out.println(LocalDateTime.now().toLocalTime().toString());//13:55:34.047

        System.out.println(LocalDateTime.MAX.toString());//+999999999-12-31T23:59:59.999999999
        System.out.println(LocalDateTime.MIN.toString());//-999999999-01-01T00:00

        new NewTimeDemo().date2LocalDateTime(new Date());
        new NewTimeDemo().localDateTime2Date(LocalDateTime.now());
    }


    /**
     * Date转换为LocalDateTime
     * @param date
     */
    public void date2LocalDateTime(Date date){
        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        System.out.println(localDateTime.toString());//2018-03-27T14:07:32.668
        System.out.println(localDateTime.toLocalDate() + " " +localDateTime.toLocalTime());//2018-03-27 14:48:57.453

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//This class is immutable and thread-safe.@since 1.8
        System.out.println(dateTimeFormatter.format(localDateTime));//2018-03-27 14:52:57
    }

    /**
     * LocalDateTime转换为Date
     * @param localDateTime
     */
    public void localDateTime2Date( LocalDateTime localDateTime){
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        System.out.println(date.toString());//Tue Mar 27 14:17:17 CST 2018
    }
}
