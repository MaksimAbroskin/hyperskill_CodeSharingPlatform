package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import platform.HTML.HtmlHandler;
import platform.JSON.JsonHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    Path path = Path.of(System.getProperty("user.dir") + File.separator + "Code Sharing Platform" + File.separator +
            "task" + File.separator + "src" + File.separator + "platform" + File.separator + "SharingCode.java");

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(path = "/code")
    public String getHtml() {
        HtmlHandler htmlHandler = new HtmlHandler(SharedCodeReader.readSharedString(path));
        return htmlHandler.wrapToHtml();
    }

    @GetMapping(path = "/api/code")
    public String getJson() {
        JsonHandler jsonHandler = new JsonHandler(SharedCodeReader.readSharedString(path));
        return jsonHandler.wrapToJson();
    }

}
