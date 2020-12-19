package platform.HTML;

import platform.JSON.JsonObject;
import platform.fileHandler.FileHandler;

import java.nio.file.Path;

public class HtmlHandler {
    final static String CODE = "#SHARED_CODE#";
    final static String TIME_OF_CHANGE = "#TIME_OF_CHANGE#";
    final static String LATEST = "#LATEST#";

    public static String wrapJsonObjectToHtml(Path pathToTemplate, JsonObject jsonObject) {
        String template = FileHandler.readFileToString(pathToTemplate);
        if (jsonObject != null) {
            return template.replace(CODE, jsonObject.getCode()).replace(TIME_OF_CHANGE, jsonObject.getDate());
        }
        return template;
    }

    public static String wrapJsonObjectToHtml(Path pathToTemplate, Path pathToInnerTemplate, JsonObject[] jsonObjects) {
        String template = FileHandler.readFileToString(pathToTemplate);
        String innerTemplate = FileHandler.readFileToString(pathToInnerTemplate);
        StringBuilder stringBuilder = new StringBuilder();
        for (JsonObject jsonObject : jsonObjects) {
            stringBuilder.append(innerTemplate.replace(CODE, jsonObject.getCode()).replace(TIME_OF_CHANGE, jsonObject.getDate()));
        }
        return template.replace(LATEST, stringBuilder);
    }

    public static String responseTo_getCodeNew(Path pathToTemplate) {
        return FileHandler.readFileToString(pathToTemplate);
    }

}
