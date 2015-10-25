/**
 * use joda
 */
package com.ichunming.joda;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class JodaExample {

	public static void main(String[] args) {
		
/*		// like DateTime, part of time is always 00:00:00
		DateMidnight d2 = new DateMidnight();
		System.out.println(d2.toString("yyyy/MM/dd HH:mm:SS"));*/

		// Create Joda-Time Object
		//DateTime dateTime1 = SystemFactory.getDateTime();
		DateTime dateTime1 = new DateTime();
		DateTime dateTime2 = new DateTime(
				2015, // year
				9,    // month
				16,   // day
				16,   // hour
				11,   // minute
				10,   // second
				0     // millisecond
				);
		DateTime dateTime3 = new DateTime(new Date().getTime());
		DateTime dateTime4 = new DateTime(new Date());
		DateTime dateTime5 = new DateTime(Calendar.getInstance());
		DateTime dateTime6 = new DateTime("2015-09-16T16:16:00");
		DateTime dateTime7 = new DateTime("2015-09-16");
		System.out.println(dateTime7.toString("yyyy/MM/dd HH:mm:SS"));
		
		// Local Date
		LocalDate localDate1 = new LocalDate();
		LocalDate localDate2 = new LocalDate(2015, 9, 16);
		System.out.println(localDate2.toString("yyyy/MM/dd"));
		
		// Local Time
		LocalTime localTime1 = new LocalTime();
		LocalTime localTime2 = new LocalTime(16, 23, 0);
		System.out.println(localTime1.toString("HH:mm:SS"));
		
		// Duration
		Duration duration = new Duration(dateTime2, dateTime1);
		System.out.println(duration.getMillis());
		
		// Period
		Period period = new Period(dateTime2, dateTime1, PeriodType.days());
		System.out.println(period.getDays());
		
		// Interval
		Interval interval = new Interval(dateTime2, dateTime1);
		System.out.println(interval.contains(dateTime3));
		
		// get year, month, day, hour...
		System.out.println(dateTime1.getYear() + " "
				+ dateTime1.getMonthOfYear() + " " 
				+ dateTime1.getDayOfMonth() + " " 
				+ dateTime1.getDayOfWeek() + " "
				+ dateTime1.getHourOfDay() + " "
				+ dateTime1.getMinuteOfHour() + " "
				+ dateTime1.getSecondOfMinute() + " "
				+ dateTime1.getZone()
				);
		
		// DateTime Compare
		boolean b1 = dateTime1.isAfter(dateTime2);
		boolean b2 = dateTime1.isBefore(dateTime2);
		boolean b3 = dateTime1.isEqual(dateTime2);
		
		// DateTime Computer
		DateTime firstDay = dateTime1.dayOfMonth().withMinimumValue();
		DateTime lastDay = dateTime1.dayOfMonth().withMaximumValue();
		DateTime yesterday = dateTime1.minusDays(1);
		DateTime tomorrow = dateTime1.plusDays(1);
		DateTime electionDate = dateTime1.minusYears(5).monthOfYear().setCopy(2).dayOfMonth().withMaximumValue();
		
	}

}
