package platform;

import java.io.File;
import java.nio.file.Path;

public class PathConstants {
    final static Path TO_SHARING_CODE_PATH = Path.of(System.getProperty("user.dir") + File.separator +
            "src" + File.separator + "resources" + File.separator + "SharingFile.txt");
    final static Path CODE_HTML_TEMPLATE_PATH = Path.of("C:\\_Java\\Code Sharing Platform\\Code Sharing Platform\\task\\src\\resources\\files\\code.html");
    final static Path CODE_NEW_HTML_TEMPLATE_PATH = Path.of("C:\\_Java\\Code Sharing Platform\\Code Sharing Platform\\task\\src\\resources\\files\\codeNew.html");

}
