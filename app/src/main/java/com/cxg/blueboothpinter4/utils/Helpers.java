/**
 * 
 */
package com.cxg.blueboothpinter4.utils;

import android.annotation.SuppressLint;
import android.app.Activity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Common functions
 * 
 * @author d053408
 * 
 */
@SuppressLint("SimpleDateFormat")
public class Helpers {

	private static SimpleDateFormat dateFormatWithoutTime;
	private static SimpleDateFormat dateFormat;
	private static DateFormat dateFormatter = new SimpleDateFormat("yy-MM-ddkk:mm:ssz");

	/**
	 * Get today's date
	 * 
	 * @return today's date
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.clear(Calendar.MILLISECOND);
		c.clear(Calendar.SECOND);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.HOUR);
		c.clear(Calendar.HOUR_OF_DAY);
		c.clear(Calendar.AM_PM);
		return c.getTime();
	}

	/**
	 * Removes the time part from a date object
	 * 
	 * @param date
	 *            Input date
	 * @return date without time part
	 */
	public static Date removeTimeFromDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.clear(Calendar.MILLISECOND);
		c.clear(Calendar.SECOND);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.HOUR);
		c.clear(Calendar.HOUR_OF_DAY);
		c.clear(Calendar.AM_PM);
		return c.getTime();
	}

	/**
	 * Checks whether a string is empty or not
	 * 
	 * @param str
	 *            String to check
	 * @return true if str is empty, false if not
	 */
//	public static boolean isEmptyString(String str) {
//		boolean flag = true;
//		if (str != null && str.length() > 0) {
//			flag = false;
//		}
//		return flag;
//	}



	/**
	 * Converts human coordinates to mapView coordinates
	 * 
	 * @param lat
	 *            Latitude
	 * @param lng
	 *            Longitude
	 * @return mapView coordinates
//	 */
//	public static GeoPoint convertToGP(double lat, double lng) {
//		if (lat == 0 && lng == 0)
//			return null;
//
//		return new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
//	}

	/**
	 * Checks if two Date objectes refer to the same day.
	 * 
	 * @param d1
	 *            Date 1
	 * @param d2
	 *            Date 2
	 * @return true if d1 and d2 are on the same day, false if not
	 */
	public static boolean isSameDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
				&& (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
				&& (c1.get(Calendar.DATE) == c2.get(Calendar.DATE));
	}

	/**
	 * generate date.
	 * 
	 * @param offset
	 *            days offset to today
	 * */
	public static Date getDate(int offset) {
		Calendar calendar = Calendar.getInstance();
		Date today = today();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, offset);
		return calendar.getTime();
	}

	public static boolean isDayInRange(Date date, Date fromDate, Date toDate) {
		return (date.compareTo(fromDate) >= 0 && date.compareTo(toDate) <= 0);
	}

	public static String getDateStrWithoutTime(Date date) {
		if (dateFormatWithoutTime == null)
			dateFormatWithoutTime = new SimpleDateFormat("yyyy-MM-dd");

		if (date != null) {
			return dateFormatWithoutTime.format(date);
		} else {
			return "";
		}
	}
	
	public static Calendar getFirstDateInMonth(Calendar date){
		int month = date.get(Calendar.MONTH);
		Calendar ret = Calendar.getInstance();
		ret.set(Calendar.MONTH, month);
		ret.set(Calendar.DAY_OF_MONTH, date.getActualMinimum(Calendar.DAY_OF_MONTH));
		return ret;
	}
	
	public static Calendar getLastDateInMonth(Calendar date){
		int month = date.get(Calendar.MONTH);
		Calendar ret = Calendar.getInstance();
		ret.set(Calendar.MONTH, month);
		ret.set(Calendar.DAY_OF_MONTH, date.getActualMaximum(Calendar.DAY_OF_MONTH));
		return ret;
	}
	

	public static String getDateStr(Date date) {
		if (dateFormat == null)
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
		return dateFormat.format(date);
	}

	public static Date getDateByStr(String dateStr) {
		if (dateFormat == null)
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
		try {
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			StringBuilder builder = new StringBuilder();
			builder.append(dateStr);
			builder.deleteCharAt(builder.indexOf("T"));
			builder.insert(builder.indexOf("+"), "GMT");
			try {
				return (Date) dateFormatter.parse(builder.toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public static String getLogTag(Activity a) {
		// for debugging, get the activity name automatically
		return a.getLocalClassName();
	}
}
