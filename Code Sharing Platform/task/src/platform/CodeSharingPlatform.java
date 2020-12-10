package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {
    String htmlStr = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n" +
            "public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
            "}</pre>\n" +
            "</body>\n" +
            "</html>";

    String jsonStr = "{\n" +
            "    \"code\": \"public static void main(String[] args) {\\n    SpringApplication.run(CodeSharingPlatform.class, args);\\n}\"\n" +
            "}";

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(path = "/code")
    public String getHtml() {
        return htmlStr;
    }

    @GetMapping(path = "/api/code")
    public String getJson() {
        return jsonStr;
    }

}
