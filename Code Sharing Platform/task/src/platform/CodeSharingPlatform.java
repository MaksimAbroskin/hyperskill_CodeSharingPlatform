package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import platform.HTML.HtmlHandler;
import platform.JSON.JsonObject;
import platform.fileHandler.FileHandler;

import java.time.LocalDateTime;

import static platform.PathConstants.*;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackageClasses= {CodeRepository.class})
public class CodeSharingPlatform {
    static DatabaseSharedCode database = new DatabaseSharedCode();

    @Autowired
    CodeService codeService;

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(path = "/code/{number}")
    public String getCodeByNumber(@PathVariable Long number) {
        return HtmlHandler.wrapJsonObjectToHtml(GET_CODE_BY_NUMBER_TEMPLATE_PATH, codeService.findById(number));
    }

    @GetMapping(path = "/code/new")
    public String getCodeNew() {
        return HtmlHandler.responseTo_getCodeNew(GET_CODE_NEW_TEMPLATE_PATH);
    }

    @GetMapping(path = "/code/latest")
    public String getCodeLatest() {
        return HtmlHandler.wrapJsonObjectToHtml(GET_CODE_LATEST_TEMPLATE_PATH, GET_CODE_LATEST_INNER_TEMPLATE_PATH, codeService.findLatest());
    }

    @GetMapping(path = "/api/code/{number}")
    public String getApiByNumber(@PathVariable Long number) {
        return codeService.findById(number).toString();
    }

    @GetMapping(path = "/api/code/latest")
    public JsonObject[] getApiLatest() {
        return codeService.findLatest();
    }

    @PostMapping(path = "/api/code/new", consumes = "application/json")
    public String postJson(@RequestBody JsonObject jsonObject) {
        jsonObject.setDate(FileHandler.printFormattedDateAndTime(LocalDateTime.now()));
        return "{ \"id\" : \"" + codeService.createNote(jsonObject) + "\" }";
    }

    @GetMapping(path = "/api/code/clear")
    public String getApiClearDb() {
        return codeService.clearDB();
    }

}
