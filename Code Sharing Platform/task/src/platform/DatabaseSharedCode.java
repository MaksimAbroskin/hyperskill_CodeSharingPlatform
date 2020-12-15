package platform;

import platform.JSON.JsonObject;
import platform.fileHandler.FileHandler;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class DatabaseSharedCode {
    public LinkedList<JsonObject> database = new LinkedList<>();

    public JsonObject getNoteByNumber(int number) {
        try {
            return database.get(number);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect index of note");
            return null;
        }
    }

    public void addNote(JsonObject jsonObject) {
        jsonObject.setDate(FileHandler.printFormattedDateAndTime(LocalDateTime.now()));
        database.add(jsonObject);
    }

}
