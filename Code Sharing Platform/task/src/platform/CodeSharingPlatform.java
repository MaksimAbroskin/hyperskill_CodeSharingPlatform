package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import platform.HTML.HtmlHandler;
import platform.JSON.JsonHandler;
import platform.JSON.JsonObject;
import platform.fileHandler.FileHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    static FileHandler fileHandler = new FileHandler();
    static DatabaseSharedCode database = new DatabaseSharedCode();

    public static void main(String[] args) {
        fileHandler = new FileHandler();
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(path = "/code/{number}")
    public String getHtmlByNumber(@PathVariable int number) {
        HtmlHandler htmlHandler = new HtmlHandler(PathConstants.CODE_HTML_TEMPLATE_PATH);
        return htmlHandler.wrapCodeToHtml(number - 1, database);
    }

    @GetMapping(path = "/code/new")
    public String getNewHtml() {
        HtmlHandler htmlHandler = new HtmlHandler(PathConstants.CODE_NEW_HTML_TEMPLATE_PATH);
        return htmlHandler.wrapCodeToHtml(LocalDateTime.now());
    }

//    @GetMapping(path = "/code/new")
//    public String getNewHtml() {
//        HtmlHandler htmlHandler = new HtmlHandler(PathConstants.CODE_NEW_HTML_TEMPLATE_PATH, PathConstants.TO_SHARING_CODE_PATH);
//        return htmlHandler.wrapCodeToHtml(fileHandler.getLastChangeTime());
//    }

    @GetMapping(path = "/api/code")
    public String getJson() {
        JsonHandler jsonHandler = new JsonHandler(FileHandler.readFileToString(PathConstants.TO_SHARING_CODE_PATH));
        return jsonHandler.wrapCodeToJson(fileHandler.getLastChangeTime());
    }

    @PostMapping(path = "/api/code/new", consumes = "application/json")
    public String postJson(@RequestBody JsonObject jsonObject) {
        database.addNote(jsonObject);
        return "{}";
    }

//    @PostMapping(path = "/api/code/new", consumes = "application/json")
//    public String postJson(@RequestBody JsonObject jsonObject) {
//        try (FileWriter fileWriter = new FileWriter(String.valueOf(PathConstants.TO_SHARING_CODE_PATH), false)) {
//            fileWriter.write(jsonObject.getCode());
//            fileHandler.setLastChangeTime();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "{}";
//    }

}
