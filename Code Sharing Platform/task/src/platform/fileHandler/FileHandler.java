package platform.fileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHandler {
    public static String readFileToString(Path path) {
        String sourceCode = "";
        try {
            sourceCode = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceCode;
    }

    public static String printFormattedDateAndTime(LocalDateTime localDateTime) {
        final String DATE_FORMATTER= "yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return localDateTime.format(formatter);
    }
}