package universityTest.adminToolsTest;

import org.junit.Before;
import org.junit.Test;
import university.adminTools.FilterTool;
import university.Student;
import university.StudentRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class FilterToolTest {

    private List<Student> students;
    private List<Student> foundStudents;

    @Before
    public void before() {
        StudentRegistry register = new StudentRegistry();

        Student s1, s2, s3, s4, s5, s6;

        s1 = new Student();
        s2 = new Student();
        s3 = new Student();
        s4 = new Student();
        s5 = new Student();
        s6 = new Student();

        s1.setName("Richard");
        s1.setAttendancePercent(74);
        s1.setDegreeTopic("geography");
        s1.setAverageGrade('b');

        s2.setName("Julia");
        s2.setAttendancePercent(88);
        s2.setDegreeTopic("history");
        s2.setAverageGrade('a');

        s3.setName("Lola");
        s3.setAttendancePercent(52);
        s3.setDegreeTopic("history");
        s3.setAverageGrade('a');

        s4.setName("Jamie");
        s4.setAttendancePercent(67);
        s4.setDegreeTopic("history");
        s4.setAverageGrade('c');

        s5.setName("Cole");
        s5.setAttendancePercent(43);
        s5.setDegreeTopic("geography");
        s5.setAverageGrade('c');

        s6.setName("Fran");
        s6.setAttendancePercent(37);
        s6.setDegreeTopic("history");
        s6.setAverageGrade('d');

        Student[] newStudents = {s1, s2, s3, s4, s5, s6};

        register.addStudents(newStudents);

        this.students = register.getStudents();
        this.foundStudents = new ArrayList<>();
    }

    @Test
    public void canGetAllStudentsOf_DegreeGeography() {
        this.foundStudents = FilterTool.filter(this.students, (Student student) -> student.getDegreeTopic().equals("geography"));
        assertEquals(2, this.foundStudents.size());
    }

    @Test
    public void canGetAllStudentsOf_DegreeHistory() {
        this.foundStudents = FilterTool.filter(this.students, student -> "history".equals(student.getDegreeTopic()));
        assertEquals(4, this.foundStudents.size());
    }

    @Test
    public void canGetAllStudentsOf_DegreeHistory_Attendance50Plus() {
        this.foundStudents = FilterTool.filter(this.students, student -> student.getDegreeTopic().equals("history")
                                                && student.getAttendancePercent() >= 50);
        assertEquals(3, this.foundStudents.size());
    }

    @Test
    public void canGetAllStudentsOf_DegreeHistory_Attendance50Plus_AnotherWay() {
        Predicate<Student> studiesHistory = student -> student.getDegreeTopic().equals("history");
        Predicate<Student> has50PlusAttendance = student -> student.getAttendancePercent() >= 50;
        this.foundStudents = FilterTool.filter(this.students, studiesHistory.and(has50PlusAttendance));
        assertEquals(3, this.foundStudents.size());
    }

    @Test
    public void canGetAllStudentsOf_DegreeHistory_Attendance50Plus_OR_GradeC() {
        Predicate<Student> studiesHistory = student -> student.getDegreeTopic().equals("history");
        Predicate<Student> has50PlusAttendance = student -> student.getAttendancePercent() >= 50;
        Predicate<Student> hasGradeC = student -> student.getAverageGrade() == 'c';

        this.foundStudents = FilterTool.filter(this.students, studiesHistory.and(has50PlusAttendance)
                                                                .or(hasGradeC));
        assertEquals(4, this.foundStudents.size());
    }
}
