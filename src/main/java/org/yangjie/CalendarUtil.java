package org.yangjie;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 日历工具类
 * 用于获取指定时间的日期
 * @author YangJie
 * @createTime 2015年2月11日 上午11:09:34
 */
public class CalendarUtil {

	/** 设置时间格式化格式 */
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	/**
	 * 获取今天日期
	 * @param dateformat
	 * @return
	 */
	public static String getToday() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, 0);
	}
	
	/**
	 * 获取昨天日期
	 * @return
	 */
	public static String getYesterday() {
		return updateCalendar(Calendar.getInstance(), -1);
	}
	
	/**
	 * 获取明天日期
	 * @return
	 */
	public static String getTomorrow() {
		return updateCalendar(Calendar.getInstance(), 1);
	}
	
	/**
	 * 获取本周一日期
	 * @return
	 */
	public static String getMondayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, getMondayAmount(calendar));
	}
	
	/**
	 * 获取上周一日期
	 * @return
	 */
	public static String getMondayOfLastWeek() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, getMondayAmount(calendar) - 7);
	}
	
	/**
	 * 获取下周一日期
	 * @return
	 */
	public static String getMondayOfNextWeek() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, getMondayAmount(calendar) + 7);
	}
		
	/**
	 * 获取本周日日期
	 * @return
	 */
	public static String getSundayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, getSundayAmount(calendar));
	}
	
	/**
	 * 获取上周日日期
	 * @return
	 */
	public static String getSundayOfLastWeek() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, getSundayAmount(calendar) - 7);
	}
	
	/**
	 * 获取下周日日期
	 * @return
	 */
	public static String getSundayOfNextWeek() {
		Calendar calendar = Calendar.getInstance();
		return updateCalendar(calendar, getSundayAmount(calendar) + 7);
	}
	
	/**
	 * 获取当月第一天日期
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 定位到1号
		return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * 获取上月第一天日期
	 * @return
	 */
	public static String getFirstDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);		// 移动到上月
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 定位到1号
		return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * 获取下月第一天日期
	 * @return
	 */
	public static String getFirstDayOfNextMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);		// 移动到下月
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 定位到1号
		return dateFormat.format(calendar.getTime());
	}
	
	/**
	 * 获取当月最后一天日期
	 * @return
	 */
	public static String getLastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);	// 移动到下月
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 定位到1号
		return updateCalendar(calendar, -1);	// 前移1天
	}
	
	/**
	 * 获取上月最后一天日期
	 * @return
	 */
	public static String getLastDayOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 定位到1号
		return updateCalendar(calendar, -1);	// 前移1天
	}
	
	/**
	 * 获取下月最后一天日期
	 * @return
	 */
	public static String getLastDayOfNextMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 2);	// 移动2个月
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 定位到1号
		return updateCalendar(calendar, -1);	// 前移1天
	}


	/**
	 * 获取本周一的偏移量
	 * @return
	 */
	private static int getMondayAmount(Calendar calendar) {
		int plus = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return plus == 1 ? 0 : 1 - plus;
	}
	
	/**
	 * 获取本周日的偏移量
	 * @return
	 */
	private static int getSundayAmount(Calendar calendar) {
		return getMondayAmount(calendar) + 6;
	}

	/**
	 * 按天更新日历
	 * @param amount
	 * @return
	 */
	private static String updateCalendar(Calendar calendar, int amount){
		calendar.add(Calendar.DATE, amount);
		return dateFormat.format(calendar.getTime());
	}

}