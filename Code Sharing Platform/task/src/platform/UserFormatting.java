package platform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserFormatting {

    public static String printFormattedDateAndTime() {
        final String DATE_FORMATTER= "yyyy/MM/dd HH:mm:ss";
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return localDateTime.format(formatter);
    }
}
