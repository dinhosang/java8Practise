package noBehaviourParamTest;

import noBehaviourParam.NoBPUniversity;
import org.junit.Before;
import org.junit.Test;
import universalModels.Student;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NoBPUniversityTest {

    private NoBPUniversity uni;

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

        this.uni = new NoBPUniversity( );
        this.uni.addStudents(student1, student2, student3);
    }

    @Test
    public void universityHasThreeStudents() {
        assertEquals(3, this.uni.getStudents().size());
    }

    @Test
    public void findWhichStudentsStudyHistory() {
        List<Student> students = this.uni.findStudentsStudyingDegree("history");
        assertEquals(2, students.size());
    }

    @Test
    public void findWhichStudentsHaveAtOrAbove50PercentAttendance() {
        List<Student> students = this.uni.findStudentsAttendanceAtOrAbove((short) 50);
        assertEquals(2, students.size());
    }

    @Test
    public void findWhichStudentsStudyHistoryAndHaveAtOrAbove50PercentAttendance() {
        List<Student> students = this.uni.findStudentsStudyingDegreeWithAttendanceAtOrAbove("history",
                                                                                            (short) 50);
        assertEquals(1, students.size());
    }

}
