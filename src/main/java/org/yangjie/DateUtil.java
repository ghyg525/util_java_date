package org.yangjie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具类
 * 
 * @author YangJie [2017年9月18日 上午11:13:43]
 */
public class DateUtil {

	public static final DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * 格式化日期时间
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) {
		return dateTimeFormat.format(date);
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}
	
	/**
	 * 格式化时间
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date) {
		return timeFormat.format(date);
	}
	
}
