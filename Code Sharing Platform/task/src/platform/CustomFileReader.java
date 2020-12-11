package platform;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomFileReader {
    public static String readFileToString(Path path) {
        String sourceCode = "";
        try {
            sourceCode = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceCode;
    }
}
