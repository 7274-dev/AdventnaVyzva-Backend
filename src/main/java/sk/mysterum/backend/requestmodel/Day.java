package sk.mysterum.backend.requestmodel;

public class  Day {
    private String body;
    private String password;
    private Integer day;

    public Day(String body, String password, Integer day) {
        this.body = body;
        this.password = password;
        this.day = day;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
