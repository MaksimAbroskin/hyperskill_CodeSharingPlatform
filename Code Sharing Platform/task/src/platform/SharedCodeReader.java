package platform;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SharedCodeReader {
    static String readSharedString(Path path) {
        String sourceCode = "";
        try {
            sourceCode = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sourceCode;
    }
}
