package records;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by DCJS
 * 2019/1/16.
 */
public class Test {

    public static void main(String[] args) {
        ttt();
    }

    public static int ttt(){
        String tradeNo = "PgiqBYwrZ8CUmrqlTryq20190416";
        String key = String.format("hash_payorders_%s", tradeNo.substring(24, 26));
        System.out.println(key);
        return 0;
        String t1 = "2018-08-10";
        String t2 = "2019-01-29";
        try {
            int result = daysBetween(t1,t2);
            System.out.println(result);
        } catch (ParseException e) {

        }
    }

    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

}
