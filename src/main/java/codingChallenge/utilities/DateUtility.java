package codingChallenge.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtility {
    static public Date getExampleDate(String ddMMyyyy) throws ParseException {
        TimeZone.setDefault(TimeZone.getTimeZone("AEST"));
        return new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyy);
    }
}
