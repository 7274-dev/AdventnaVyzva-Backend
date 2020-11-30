package sk.mysterum.backend.requestmodel;


public class ExerciseFile {
    private Integer day;
    private String userName;
    private Byte[] data;
    private String filename;

    public ExerciseFile(Integer day, String userName, Byte[] data, String filename) {
        this.day = day;
        this.userName = userName;
        this.data = data;
        this.filename = filename;
    }

    public ExerciseFile() {
        this.day = null;
        this.userName = null;
        this.data = null;
        this.filename = null;
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

    public void setDay(Integer day) {
        this.day = day;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
