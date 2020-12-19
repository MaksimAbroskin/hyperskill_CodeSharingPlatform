package platform.HTML;

import platform.DatabaseSharedCode;
import platform.JSON.JsonObject;
import platform.fileHandler.FileHandler;

import java.nio.file.Path;

public class HtmlHandler {
    final static String CODE = "#SHARED_CODE#";
    final static String TIME_OF_CHANGE = "#TIME_OF_CHANGE#";
    final static String LATEST = "#LATEST#";

    public static String responseTo_getCodeNumber(Path pathToTemplate, DatabaseSharedCode database, int number) {
        JsonObject note = database.getNoteByNumber(number);
        String template = FileHandler.readFileToString(pathToTemplate);
        if (note != null) {
            return template.replace(CODE, note.getCode()).replace(TIME_OF_CHANGE, note.getDate());
        }
        return template;
    }

    public static String wrapJsonObjectToHtml(Path pathToTemplate, JsonObject jsonObject) {
        String template = FileHandler.readFileToString(pathToTemplate);
        if (jsonObject != null) {
            return template.replace(CODE, jsonObject.getCode()).replace(TIME_OF_CHANGE, jsonObject.getDate());
        }
        return template;
    }

    public static String responseTo_getCodeNew(Path pathToTemplate) {
        return FileHandler.readFileToString(pathToTemplate);
    }

    public static String responseTo_getCodeLatest(Path pathToTemplate, Path pathToInnerTemplate, DatabaseSharedCode database) {
        String template = FileHandler.readFileToString(pathToTemplate);
        String innerTemplate = FileHandler.readFileToString(pathToInnerTemplate);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = database.getSize() - 1; i > database.getSize() - 11; i--) {
            if (i < 0) break;
            stringBuilder.append(innerTemplate.replace(CODE, database.getNoteByNumber(i).getCode()).replace(TIME_OF_CHANGE, database.getNoteByNumber(i).getDate()));
        }

        return template.replace(LATEST, stringBuilder);
    }

}
