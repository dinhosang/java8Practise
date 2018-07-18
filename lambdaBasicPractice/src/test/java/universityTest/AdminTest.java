package universityTest;

import org.junit.Before;
import org.junit.Test;
import university.Admin;
import university.Student;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class AdminTest {

    Admin admin;

    @Before
    public void before() {
        this.admin = new Admin();
    }

    @Test
    public void lambdaInAdmin_FilterCaptureInstanceMethod_CanUseInstanceVariable_ADegreeTopic() {
        List<Student> students = this.admin.filterInternalLambdaCaptureInstanceVariableValue();
        assertEquals(4, students.size());
    }

    @Test
    public void adminInstanceVariable_AnotherDegreeTopic_StartsWithValue_History() {
        assertEquals("english", this.admin.getAnotherDegreeTopic());
    }

    @Test
    public void lambdaInAdmin_FilterModifyInstanceMethod_CanModifyInstanceVariable_AnotherDegreeTopic() {
        List<Student> students = this.admin.filterInternalLambdaModifyInstanceVariable();
        assertEquals(2, students.size());
        assertEquals("geography", this.admin.getAnotherDegreeTopic());
    }

    @Test
    public void lambdaOutsideAdmin_FilterCaptureLocalVariable_aVariable() {
        String aVariable = "geography";
        Predicate<Student> predicate = student -> student.getDegreeTopic().equals(aVariable);
        List<Student> students = this.admin.filterExternalLambdaCaptureExternalLocalVariable(predicate);
        assertEquals(2, students.size());
    }

    @Test
    public void lambdaOutsideAdmin_FilterModifyInternalStaticVariable_aThirdDegree() {
        Predicate<Student> predicate = student -> {
            Admin.aThirdDegree = "geography";
            return student.getDegreeTopic().equals(Admin.aThirdDegree);
        };
        List<Student> students = this.admin.filterExternalLambdaModifyStaticInstanceVariable(predicate);
    }
}
