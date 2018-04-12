package nosql.anew.chatmvvm.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by saksham on 25/6/17.
 */

public class MyUtils {
    public static String MESSAGE_AUTHENTICATION_FAILED = "Firebase authentication failed, please check your internet connection";
    public static String MESSAGE_INVALIDE_ROOM_NAME= "Enter a valid Name";

    public static String EXTRA_ROOM_NAME="EXTRA_ROOM_NAME";

    public static final int OPEN_ACTIVITY = 1;
    public static final int SHOW_TOAST = 2;
    public static final int UPDATE_MESSAGES=1;

    public static String convertTime(long timestamp) {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(timestamp);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }
}
