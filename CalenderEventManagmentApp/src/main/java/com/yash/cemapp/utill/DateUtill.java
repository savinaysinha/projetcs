package com.yash.cemapp.utill;

import java.util.Date;
import java.util.concurrent.TimeUnit;
 /**
  * This class will convert two java.util.Date into number of days 
  * @author savinay.sinha
  *
  */
public class DateUtill {
	public static long convertDatesToDays(Date startDate, Date endDate) {
			long diff = endDate.getTime() - startDate.getTime();
			long days=  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			return days;
	}
}
