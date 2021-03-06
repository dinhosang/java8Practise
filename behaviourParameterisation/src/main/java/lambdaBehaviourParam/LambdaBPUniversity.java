package lambdaBehaviourParam;

import universalModels.Student;
import universalModels.University;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaBPUniversity extends University {

    public List<Student> findStudents(Predicate<Student> predicate) {

        List<Student> foundStudents = new ArrayList<>();

        for(Student student : this.students) {
            if(predicate.test(student)) {
                foundStudents.add(student);
            }
        }

        return foundStudents;
    }
}
