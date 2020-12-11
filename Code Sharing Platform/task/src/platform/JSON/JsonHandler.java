package platform.JSON;

public class JsonHandler {
    String in;

    public JsonHandler(String in) {
        this.in = in;
    }

    public String wrapToJson() {
        return "{ \"code\" : \"" + in + "\"}";
    }
}
