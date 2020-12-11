package platform.HTML;

public class HtmlHandler {
    String in;
    String prefix = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n";
    String postfix = "\n</pre>\n" +
            "</body>\n" +
            "</html>";

    public HtmlHandler(String in) {
        this.in = in;
    }

    public String wrapToHtml() {
        return prefix + in + postfix;
    }
}
