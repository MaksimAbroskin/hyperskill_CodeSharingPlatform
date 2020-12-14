package platform.JSON;

import java.time.LocalDateTime;

import static platform.fileHandler.FileHandler.printFormattedDateAndTime;

public class JsonHandler {
    String template = "{\n" +
            "\t\"code\": \"#CODE#\"," +
            "\t\"date\": \"#DATE#\"" +
            "}";
    String in;

    public JsonHandler(String in) {
        this.in = in;
    }

    public String wrapCodeToJson(LocalDateTime localDateTime) {
        return template.replace("#CODE#", in).replace("#DATE#", printFormattedDateAndTime(localDateTime));
    }
}
