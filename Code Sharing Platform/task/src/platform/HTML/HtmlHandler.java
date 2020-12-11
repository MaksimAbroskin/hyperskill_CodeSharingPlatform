package platform.HTML;

import platform.CustomFileReader;
import platform.UserFormatting;

import java.io.File;
import java.nio.file.Path;

public class HtmlHandler {
    final static String textForReplace = "EXTERNAL_CODE";
    final static String timeForReplace = "TIME_OF_CHANGE";
    Path path = Path.of(System.getProperty("user.dir") + File.separator + "file.html");
    String code;
    String html;

    public HtmlHandler(String in) {
        this.code = in;
    }

    public String wrapToHtml() {
        html = CustomFileReader.readFileToString(path);
        return html.replace(textForReplace, code).replace(timeForReplace, UserFormatting.printFormattedDateAndTime());
    }
}
