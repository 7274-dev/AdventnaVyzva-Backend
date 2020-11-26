package sk.mysterum.backend.requestmodel;


public class ExerciseFile {
    private Integer day;
    private String userName;

    public ExerciseFile(int day, String userName) {
        this.day = day;
        this.userName = userName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ExerciseFile() {
        this.day = null;
        this.userName = null;
    }
}
