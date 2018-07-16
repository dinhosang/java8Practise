package classBehaviourParam.classPredicates;

import universalModels.Student;

import java.util.function.Predicate;

public class degreeAndAttendanceFilter implements Predicate<Student> {

    private String  degreeTopic;
    private short   attendanceFilterValue;

    public degreeAndAttendanceFilter(String degreeTopic, short attendanceFilterValue) {
        this.degreeTopic = degreeTopic;
        this.attendanceFilterValue = attendanceFilterValue;
    }

    @Override
    public boolean test(Student student) {
        return student.getDegreeTopic().equals(this.degreeTopic) &&
                student.getAttendancePercent() >= this.attendanceFilterValue;
    }
}
