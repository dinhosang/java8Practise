import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private Student student;

    @Before
    public void before() {
        this.student = new Student("Richard");
        this.student.setAttendancePercent((short) 74);
        this.student.setDegreeTopic("geography");
        this.student.setAverageGrade('b');
    }

    @Test
    public void canGetStudentName() {
        assertEquals("Richard", this.student.getName());
    }

    @Test
    public void canGetStudentAttendanceRecord() {
        assertEquals(74, this.student.getAttendancePercent());
    }

    @Test
    public void canGetStudentDegreeTopic() {
        assertEquals("geography", this.student.getDegreeTopic());
    }

    @Test
    public void canGetStudentsAverageGrade(){
        assertEquals('b', this.student.getAverageGrade());
    }
}
