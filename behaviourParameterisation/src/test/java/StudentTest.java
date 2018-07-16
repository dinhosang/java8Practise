import org.junit.Before;
import org.junit.Test;
import universalModels.Student;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private Student student;

    @Before
    public void before() {
        this.student = new Student("Richard");
        this.student.setAttendancePercent((short) 74);
        this.student.setDegreeTopic("geography");
    }

    @Test
    public void studentHasName() {
        assertEquals("Richard", student.getName());
    }

    @Test
    public void studentHasAttendanceRecordOf74() {
        assertEquals(74, student.getAttendancePercent());
    }

    @Test
    public void studentStudiesGeography() {
        assertEquals("geography", student.getDegreeTopic());
    }
}
