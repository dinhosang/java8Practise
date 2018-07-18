package university;

import university.adminTools.FilterTool;
import university.adminTools.SortTool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Admin {

    private FilterTool filterTool;
    private SortTool sortTool;
    private StudentRegistry register;
    private String aDegreeTopic;
    private String anotherDegreeTopic;
    public static String aThirdDegree;

    public Admin() {
        this.filterTool = new FilterTool();
        this.sortTool = new SortTool();
        this.register = new StudentRegistry();
        this.aDegreeTopic = "history";
        this.anotherDegreeTopic = "english";
        this.aThirdDegree = "maths";

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

        this.register.addStudents(newStudents);
    }


    public List<Student> filterInternalLambdaCaptureInstanceVariableValue() {
        List<Student> students = new ArrayList<>(this.register.getStudents());
        return FilterTool.filter(students, s -> s.getDegreeTopic().equals(this.aDegreeTopic));
    }

    public String getAnotherDegreeTopic() {
        return this.anotherDegreeTopic;
    }

    // below works because instance variables are stored on the heap and so would be visible to all threads
    // thus java allows the below to occur because it would not cause issues where one thread is out of sync
    // with other threads in regard to the variable's value.
    public List<Student> filterInternalLambdaModifyInstanceVariable() {
        List<Student> students = new ArrayList<>(this.register.getStudents());
        return FilterTool.filter(students, s -> {
            anotherDegreeTopic = "geography";
            return s.getDegreeTopic().equals(this.anotherDegreeTopic);
        });
    }

    public List<Student> filterExternalLambdaCaptureExternalLocalVariable(Predicate<Student> ruleset) {
        List<Student> students = new ArrayList<>(this.register.getStudents());
        return FilterTool.filter(students, ruleset);
    }

    public List<Student> filterExternalLambdaModifyStaticInstanceVariable(Predicate<Student> ruleset) {
        List<Student> students = new ArrayList<>(this.register.getStudents());
        return FilterTool.filter(students, ruleset);
    }

//
////     Below does not work as it is trying to modify a local variable which is a feature that is not allowed to lambdas.
//
//    public List<Student> filterInternalLambdaModifyLocalVariable() {
//        String aVariable = "history";
//        List<Student> students = new ArrayList<>(this.register.getStudents());
//        return FilterTool.filter(students, student -> {
//            aVariable = "geography";
//            return student.getDegreeTopic().equals(aVariable);
//        });
//    }


}
