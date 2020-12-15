package platform.HTML;

import platform.DatabaseSharedCode;
import platform.JSON.JsonObject;
import platform.fileHandler.FileHandler;

import java.nio.file.Path;
import java.time.LocalDateTime;

import static platform.fileHandler.FileHandler.printFormattedDateAndTime;

public class HtmlHandler {
    final static String textForReplace = "EXTERNAL_CODE";
    final static String timeForReplace = "TIME_OF_CHANGE";
    String code;
    String html;
//    DatabaseSharedCode database = new DatabaseSharedCode();

    public HtmlHandler(Path pathToHtmlTemplate) {
        this.html = FileHandler.readFileToString(pathToHtmlTemplate);
        this.code = "";
    }

    public HtmlHandler(Path pathToHtmlTemplate, Path pathToSharingCode) {
        this.html = FileHandler.readFileToString(pathToHtmlTemplate);
        this.code = FileHandler.readFileToString(pathToSharingCode);
    }

    public String wrapCodeToHtml(LocalDateTime localDateTime) {

        return html.replace(textForReplace, code).replace(timeForReplace, printFormattedDateAndTime(localDateTime));
    }

    public String wrapCodeToHtml(int number, DatabaseSharedCode database) {
        JsonObject note = database.getNoteByNumber(number);
//        System.out.println("note = " + note.toString());
//        System.out.println("database = ");
//        for (int i = 0; i < database.database.size(); i++) {
//            System.out.println(database.getNoteByNumber(i));
//        }
//        System.out.println("html = " + html);
        if (note != null) {
            return html.replace(textForReplace, note.getCode()).replace(timeForReplace, note.getDate());
        }
        return html.replace(textForReplace, "Incorrect index of note").replace(timeForReplace, FileHandler.printFormattedDateAndTime(LocalDateTime.now()));
    }
}
