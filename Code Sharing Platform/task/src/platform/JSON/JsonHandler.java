package platform.JSON;

import platform.UserFormatting;

public class JsonHandler {
    String template = "{\n" +
            "\t\"code\": \"#CODE#\"," +
            "\t\"date\": \"#DATE#\"" +
            "}";
    String in;

    public JsonHandler(String in) {
        this.in = in;
    }

    public String wrapToJson() {
        return template.replace("#CODE#", in).replace("#DATE#", UserFormatting.printFormattedDateAndTime());
    }
}
