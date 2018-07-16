package universalModels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {

    protected List<Student> students;

    protected University() {
        this.students = new ArrayList<>();
    }

    public void addStudents(Student... students) {
        Collections.addAll(this.students, students);
    }

    public List<Student> getStudents() {
        List<Student> copyList = new ArrayList<>(this.students);
        return copyList;
    }
}
