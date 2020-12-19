package platform.JSON;

import javax.persistence.*;

@Entity(name="jsonObject")
public class JsonObject {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String code;
    @Column
    private String date;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "{\n" +
//                "\t\"id\": \"" + id + "\",\n" +
                "\t\"code\": \"" + code + "\",\n" +
                "\t\"date\": \"" + date + "\"\n" +
                "}";
    }
}
