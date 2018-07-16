package noBehaviourParam;

import universalModels.Student;
import universalModels.University;

import java.util.ArrayList;
import java.util.List;

public class NoBPUniversity extends University {

    public NoBPUniversity() {
    }

    public List<Student> findStudentsStudyingDegree(String degreeTopic) {

        List<Student> foundStudents = new ArrayList<>();

        for(Student student : this.students) {
            if(student.getDegreeTopic().equals(degreeTopic)) {
                foundStudents.add(student);
            }
        }

        return foundStudents;
    }

    public List<Student> findStudentsAttendanceAtOrAbove(short attendancePercent) {

        List<Student> foundStudents = new ArrayList<>();

        for(Student student : this.students) {
            if(student.getAttendancePercent() >= attendancePercent) {
                foundStudents.add(student);
            }
        }

        return foundStudents;
    }

    public List<Student> findStudentsStudyingDegreeWithAttendanceAtOrAbove(String degreeTopic, short attendancePercent) {

        List<Student> foundStudents = new ArrayList<>();

        for(Student student : this.students) {
            if(student.getAttendancePercent() >= attendancePercent && student.getDegreeTopic().equals(degreeTopic)) {
                foundStudents.add(student);
            }
        }

        return foundStudents;
    }
}
