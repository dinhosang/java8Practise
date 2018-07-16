package classBehaviourParam.classPredicates;

import universalModels.Student;

import java.util.function.Predicate;

public class degreeTopicFilter implements Predicate<Student> {

    private String degreeTopic;

    public degreeTopicFilter(String degreeTopic) {
        this.degreeTopic = degreeTopic;
    }

    @Override
    public boolean test(Student student) {
        return student.getDegreeTopic().equals(this.degreeTopic);
    }
}
