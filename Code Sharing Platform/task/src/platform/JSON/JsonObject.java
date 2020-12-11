package platform.JSON;

public class JsonObject {
    String code;
    String date;

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
