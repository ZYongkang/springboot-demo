package com.springboot.demo.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeUtils {
	private static Logger logger =LoggerFactory.getLogger(TimeUtils.class);
	
    /**
     * 判断是否在某个时间是否在某个时间段内
     * @param nowTime 要判断的时间
     * @param beginTime 时间段开始时间
     * @param endTime 时间段结束时间
     * @return 在时间段内为true
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
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
     * 忘了什么作用了。。
     * 应该是获取当天的24点
     * @param time
     * @return
     */
    public static Date get(Date time) {
        long now = time.getTime();
        long daySecond = 60 * 60 * 24;
        long dayTime = now - (now + 8 * 3600) % daySecond;
        return new Date(dayTime);
    }

    /**
     * 获取unix服务器上当天的24点的时间戳
     * @return
     */
    public static long getUnixTimesnight(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    /**
     * 获取unix服务器上当天的0点的时间戳
     * @return
     */
    public static long getUnixTimesmorning(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }
    /**
     * @desc java获取当天的24点的时间戳 单位:S
     * @return
     */
    public static long getTimesnight(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    /**
     * java获取指定天的24点的时间戳
     * @return
     */
    public static long getTimesnight(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }


    /**
     * java获取当天的0点的时间戳
     * @return
     */
    public static long getTimesmorning(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    /**
     * 格式化时间类型为字符串yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getFormatDateDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 格式化时间类型为指定格式的字符串
     * @param date
     * @return
     */
    public static String getFormatDateDay(Date date, String format){
        String realFormat = format;
        if(format==null || Objects.equals(format, "")){
            realFormat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(realFormat);
        return sdf.format(date);
    }
    
    /*public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if(null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),    calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }*/

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String format = sdf.format(date);
//        Date parse = sdf.parse(format);
//        long time = parse.getTime();

        String time = formatDuration2MinuteTime(100);
        System.out.println(time);

    }

    /**
     * 判断当前时间和给定时间相差几天
     * @param token
     * @return
     */
    public static int differentDaysByToken(Long token) {
        Date date = new Date(token);
        Date nowDate = new Date();
        return (int) (Math.abs(nowDate.getTime() - date.getTime()) / (1000*3600*24));
    }

    /**
     * 根据duration格式化为time（00：00：00）
     * @param duration
     * @return
     */
    public static String formatDuration2Time(Integer duration) {
        String time = "00:00:00";
        if(duration !=null){
            DecimalFormat df = new DecimalFormat("00");
            int m = duration / 60;
            int s = duration % 60;
            time = df.format(m) + ":" + df.format(s);
        }
        return time;
    }

    /**
     * 根据duration格式化为time（00：00：00）
     * @param duration
     * @return
     */
    public static String formatDuration2MinuteTime(Integer duration) {
        String time = "00:00";
        if(duration !=null){
            DecimalFormat df = new DecimalFormat("00");
            int m = duration / 60;
            int s = duration % 60;
            time = df.format(m) + ":" + df.format(s);
        }
        return time;
    }
}
