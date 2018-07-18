package university;

public class Student {

    private String name;
    private int attendance;
    private String degreeTopic;
    private char averageGrade;

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setAttendancePercent(int number) {
        // should really check if between 0 and 100 inclusive and raise exception if not
        // or code that sends value to this has such a check so no need here, as long as that's the case.

        this.attendance = number;
    }

    public int getAttendancePercent() {
        return this.attendance;
    }

    public void setDegreeTopic(String topic) {
        this.degreeTopic = topic;
    }

    public String getDegreeTopic() {
        return this.degreeTopic;
    }

    public void setAverageGrade(char grade) {
        this.averageGrade = grade;
    }

    public char getAverageGrade() {
        return this.averageGrade;
    }
}
