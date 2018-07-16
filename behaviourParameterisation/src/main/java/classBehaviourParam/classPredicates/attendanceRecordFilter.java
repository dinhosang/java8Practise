package classBehaviourParam.classPredicates;

import universalModels.Student;

import java.util.function.Predicate;

public class attendanceRecordFilter implements Predicate<Student> {

    private short attendanceFilterValue;

    public attendanceRecordFilter(short attendanceFilterValue){
        this.attendanceFilterValue = attendanceFilterValue;
    }

    @Override
    public boolean test(Student student) {
        return student.getAttendancePercent() >= this.attendanceFilterValue;
    }
}
