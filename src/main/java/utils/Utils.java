package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static boolean lessThan5Seconds(long startTime) {
        return (System.currentTimeMillis() - startTime) < 5000;
    }

    public static LocalDate stringToDate(String dateAsString, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateAsString, formatter);
    }

}
