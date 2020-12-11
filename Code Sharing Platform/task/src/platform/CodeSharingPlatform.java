package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import platform.HTML.HtmlHandler;
import platform.JSON.JsonHandler;
import platform.JSON.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

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
        HtmlHandler htmlHandler = new HtmlHandler(CustomFileReader.readFileToString(path));
        return htmlHandler.wrapToHtml();
    }

    @GetMapping(path = "/api/code")
    public String getJson() {
        JsonHandler jsonHandler = new JsonHandler(CustomFileReader.readFileToString(path));
        return jsonHandler.wrapToJson();
    }

    @PostMapping(path = "/api/code/new", consumes = "application/json")
    public String postJson(@RequestBody JsonObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(String.valueOf(path), true)) {
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "string";
    }

}
