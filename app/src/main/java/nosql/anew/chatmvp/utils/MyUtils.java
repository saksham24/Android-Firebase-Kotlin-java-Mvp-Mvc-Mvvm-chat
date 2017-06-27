package nosql.anew.chatmvp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by saksham on 25/6/17.
 */

public class MyUtils {
    public static String EXTRA_ROOM_NAME="EXTRA_ROOM_NAME";

    public static String convertTime(long timestamp) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(timestamp);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }
}
