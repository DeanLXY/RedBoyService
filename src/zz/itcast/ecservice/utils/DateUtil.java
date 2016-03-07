package zz.itcast.ecservice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取上个月
	 * @return
	 */
	public static String getLastDate() {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());
	        cal.add(Calendar.MONTH, -1);
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
	        return  format.format(cal.getTime());
	    }


}
