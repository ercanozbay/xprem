package tr.com.xprem.customer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {
/*
    public static Date addMonth(long month) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd/MM/yyyy");
        Date currentDate = formatter.parse(formatter.format(new Date()));

        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusMonths(month);
        Date newDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        return newDate;

    }
*/

    public static Date addMonth( int i) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "dd/MM/yyyy");
        Date currentDate = formatter.parse(formatter.format(new Date()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
    }

    public static void main(String[] args) throws Throwable {
        addMonth(1);
    }
}
