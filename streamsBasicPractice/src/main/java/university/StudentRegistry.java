package university;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRegistry {

    private List<Student> students;

    public StudentRegistry() {
        this.students = new ArrayList<>();
    }

    public void addStudents(Student[] students) {
        Collections.addAll(this.students, students);
    }

    public List<Student> getStudents() {
        List<Student> copyList = new ArrayList<>(this.students);
        return copyList;
    }
}
