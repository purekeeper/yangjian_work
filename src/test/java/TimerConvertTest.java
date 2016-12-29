import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangjian on 16-12-29.
 */
public class TimerConvertTest {
    @Test
    public void timerTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse("2016-12-29 09:51:27");
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
