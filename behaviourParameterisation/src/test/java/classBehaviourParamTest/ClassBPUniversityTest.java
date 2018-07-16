package classBehaviourParamTest;

import classBehaviourParam.ClassBPUniversity;
import classBehaviourParam.classPredicates.attendanceRecordFilter;
import classBehaviourParam.classPredicates.degreeAndAttendanceFilter;
import classBehaviourParam.classPredicates.degreeTopicFilter;
import org.junit.Before;
import org.junit.Test;
import universalModels.Student;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClassBPUniversityTest {

    private ClassBPUniversity uni;

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

        this.uni = new ClassBPUniversity( );
        this.uni.addStudents(student1, student2, student3);
    }


    @Test
    public void findWhichStudentsStudyHistory() {
        List<Student> students = this.uni.findStudents(new degreeTopicFilter("history"));
        assertEquals(2, students.size());
    }

    @Test
    public void findWhichStudentsStudyArt() {
        List<Student> students = this.uni.findStudents(new degreeTopicFilter("art"));
        assertEquals(1, students.size());
    }

    @Test
    public void findWhichStudentsStudyGeography() {
        List<Student> students = this.uni.findStudents(new degreeTopicFilter("geography"));
        assertEquals(0, students.size());
    }


    @Test
    public void findWhichStudentsHaveAtOrAbove50PercentAttendance() {
        List<Student> students = this.uni.findStudents(new attendanceRecordFilter((short) 50));
        assertEquals(2, students.size());
    }

    @Test
    public void findWhichStudentsStudyHistoryAndHaveAtOrAbove50PercentAttendance() {
        List<Student> students = this.uni.findStudents( new degreeAndAttendanceFilter("history",
                (short) 50));
        assertEquals(1, students.size());
    }

}
