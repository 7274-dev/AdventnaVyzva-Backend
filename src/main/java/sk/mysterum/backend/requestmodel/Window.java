package sk.mysterum.backend.requestmodel;

public class Window {
    private Integer day;
    private String userName;

    public Window(Integer day, String userName) {
        this.day = day;
        this.userName = userName;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Window{" +
                "day=" + day +
                ", userName='" + userName + '\'' +
                '}';
    }
}
