package anonClassBehaviourParamTest;

import anonClassBehaviourParam.AnonClassBPUniversity;
import org.junit.Before;
import org.junit.Test;
import universalModels.Student;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class AnonClassBPUniversityTest {

    private AnonClassBPUniversity uni;

    @Before
    public void before() {
        Student student1;
        Student student2;
        Student student3;

        student1 = new Student("Rachel");
        student1.setAttendancePercent((short) 89);
        student1.setDegreeTopic("history");

        student2 = new Student("Joss");
        student2.setAttendancePercent((short) 52);
        student2.setDegreeTopic("art");

        student3 = new Student("Karen");
        student3.setAttendancePercent((short) 34);
        student3.setDegreeTopic("history");

        this.uni = new AnonClassBPUniversity( );
        this.uni.addStudents(student1, student2, student3);
    }

    @Test
    public void findWhichStudentsStudyHistory() {
        List<Student> students = this.uni.findStudents(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getDegreeTopic().equals("history");
            }
        });
        assertEquals(2, students.size());
    }

    @Test
    public void findWhichStudentsStudyArt() {
        List<Student> students = this.uni.findStudents(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getDegreeTopic().equals("art");
            }
        });
        assertEquals(1, students.size());
    }

    @Test
    public void findWhichStudentsStudyGeography() {
        List<Student> students = this.uni.findStudents(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getDegreeTopic().equals("geography");
            }
        });
        assertEquals(0, students.size());
    }


    @Test
    public void findWhichStudentsHaveAtOrAbove50PercentAttendance() {
        List<Student> students = this.uni.findStudents(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAttendancePercent() >= (short) 50;
            }
        });
        assertEquals(2, students.size());
    }

    @Test
    public void findWhichStudentsStudyHistoryAndHaveAtOrAbove50PercentAttendance() {
        List<Student> students = this.uni.findStudents(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return (student.getAttendancePercent() >= (short) 50) &&
                        (student.getDegreeTopic().equals("history"));
            }
        });
        assertEquals(1, students.size());
    }

}
