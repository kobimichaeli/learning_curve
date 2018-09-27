package utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date_time {
    private DateFormat dateFormat = null;
    private Date date = null;

    public date_time (boolean is_long) {
        date = new Date();
        String long_format = "yyyy/MM/dd HH:mm:ss";
        String short_format = "yy/MM/dd HH:mm";
        if (is_long)
            dateFormat  = new SimpleDateFormat(long_format);
        else
            dateFormat  = new SimpleDateFormat(short_format);
    }

    public String get_date_time () {
        return this.dateFormat.format(date);
    }

}
//TODO: Create an hour return only
//TODO: Have more format objects on the go
//TODO: consider making this static so it can be consumed as a util service
