package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import platform.HTML.HtmlHandler;
import platform.JSON.JsonHandler;
import platform.JSON.JsonObject;

import static platform.PathConstants.*;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    static DatabaseSharedCode database = new DatabaseSharedCode();

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(path = "/code/{number}")
    public String getCodeByNumber(@PathVariable int number) {
        return HtmlHandler.responseTo_getCodeNumber(GET_CODE_BY_NUMBER_TEMPLATE_PATH, database, number - 1);
    }

    @GetMapping(path = "/code/new")
    public String getCodeNew() {
        return HtmlHandler.responseTo_getCodeNew(GET_CODE_NEW_TEMPLATE_PATH);
    }

    @GetMapping(path = "/code/latest")
    public String getCodeLatest() {
        return HtmlHandler.responseTo_getCodeLatest(GET_CODE_LATEST_TEMPLATE_PATH, GET_CODE_LATEST_INNER_TEMPLATE_PATH, database);
    }

    @GetMapping(path = "/api/code/{number}")
    public String getApiByNumber(@PathVariable int number) {
        return JsonHandler.responseFor_getApiCodeNumber(number - 1, database);
    }

    @GetMapping(path = "/api/code/latest")
    public JsonObject[] getApiLatest() {
        return JsonHandler.responseFor_getApiCodeLatest(database);
    }

    @PostMapping(path = "/api/code/new", consumes = "application/json")
    public String postJson(@RequestBody JsonObject jsonObject) {
        return database.addNote(jsonObject);
    }

}
