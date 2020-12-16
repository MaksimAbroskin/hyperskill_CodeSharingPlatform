package platform.JSON;

import platform.DatabaseSharedCode;
import java.time.LocalDateTime;
import java.util.LinkedList;

import static platform.fileHandler.FileHandler.printFormattedDateAndTime;

public class JsonHandler {
    static String template = "{\n" +
            "\t\"code\": \"#CODE#\",\n" +
            "\t\"date\": \"#DATE#\"\n" +
            "}";

    public static String responseFor_getApiCodeNumber(int number, DatabaseSharedCode database) {
        JsonObject note = database.getNoteByNumber(number);
        if (note != null) {
            return template.replace("#CODE#", note.getCode()).replace("#DATE#", note.getDate());
        }
        return template.replace("#CODE#", "Incorrect index of note").replace("#DATE#", printFormattedDateAndTime(LocalDateTime.now()));
    }

    public static JsonObject[] responseFor_getApiCodeLatest(DatabaseSharedCode database) {
        LinkedList<JsonObject> list = new LinkedList<>();
        for (int i = database.getSize() - 1; i > database.getSize() - 11; i--) {
            if (i < 0) break;
            list.add(database.getNoteByNumber(i));
        }
        return list.toArray(new JsonObject[0]);
    }

}
