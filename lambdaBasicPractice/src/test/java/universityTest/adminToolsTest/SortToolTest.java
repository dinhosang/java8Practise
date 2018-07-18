package universityTest.adminToolsTest;

import org.junit.Before;
import org.junit.Test;
import university.adminTools.SortTool;
import university.Student;
import university.StudentRegistry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static org.junit.Assert.assertEquals;

public class SortToolTest {

    private List<Student> students;
    private List<Student> foundStudents;
    private List<Student> sortedStudents;

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
        this.sortedStudents = new ArrayList<>();
    }

    @Test
    public void canOrderAllStudentsBy_Grade_Cumbersome() {
        this.sortedStudents = SortTool.sort(this.students, (s1, s2) -> ((Character) s1.getAverageGrade()).compareTo(s2.getAverageGrade()));
        assertEquals("Richard", this.sortedStudents.get(2).getName());
        assertEquals("Fran", this.sortedStudents.get(5).getName());
    }

    @Test
    public void canOrderAllStudentsBy_Grade_WithMethodReference() {
        this.sortedStudents = SortTool.sort(this.students, Comparator.comparing(Student::getAverageGrade));
        assertEquals("Richard", this.sortedStudents.get(2).getName());
        assertEquals("Fran", this.sortedStudents.get(5).getName());
        assertEquals("Julia", this.sortedStudents.get(0).getName());
    }

    @Test
    public void canOrderAllStudentsBy_Attendance_HavingImportedStaticMethodFromComparatorInterface_NoAutoBoxing() {
        this.sortedStudents = SortTool.sort(this.students, comparingInt(Student::getAttendancePercent));
        assertEquals(6, this.sortedStudents.size());

        assertEquals("Fran", this.sortedStudents.get(0).getName());
        assertEquals("Julia", this.sortedStudents.get(5).getName());
    }

    @Test
    public void canOrderAllStudentsBy_Grade_AndThen_Attendance() {
        this.sortedStudents = SortTool.sort(this.students, comparing(Student::getAverageGrade)
                                                            .thenComparingInt(Student::getAttendancePercent));
        assertEquals("Lola", this.sortedStudents.get(0).getName());
    }

    @Test
    public void canOrderAllStudentsBy_Grade_AscendingOrder() {
        this.sortedStudents = SortTool.sort(this.students, comparing(Student::getAverageGrade).reversed());
        assertEquals("Fran", this.sortedStudents.get(0).getName());
    }

//    @Test
//    public void canGetAllStudentsOf_DegreeHistory() {
//        this.foundStudents = FilterTool.filter(this.students, student -> "history".equals(student.getDegreeTopic()));
//        assertEquals(4, this.foundStudents.size());
//    }
//
//    @Test
//    public void canGetAllStudentsOf_DegreeHistory_Attendance50Plus() {
//        this.foundStudents = FilterTool.filter(this.students, student -> student.getDegreeTopic().equals("history")
//                && student.getAttendancePercent() >= 50);
//        assertEquals(3, this.foundStudents.size());
//    }


}
