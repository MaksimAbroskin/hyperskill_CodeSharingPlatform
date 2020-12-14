package platform.HTML;

import platform.fileHandler.FileHandler;

import java.nio.file.Path;
import java.time.LocalDateTime;

import static platform.fileHandler.FileHandler.printFormattedDateAndTime;

public class HtmlHandler {
    final static String textForReplace = "EXTERNAL_CODE";
    final static String timeForReplace = "TIME_OF_CHANGE";
    String code;
    String html;

    public HtmlHandler(Path pathToHtmlTemplate, Path pathToSharingCode) {
        this.html = FileHandler.readFileToString(pathToHtmlTemplate);
        this.code = FileHandler.readFileToString(pathToSharingCode);
    }

    public String wrapCodeToHtml(LocalDateTime localDateTime) {
        return html.replace(textForReplace, code).replace(timeForReplace, printFormattedDateAndTime(localDateTime));
    }
}
