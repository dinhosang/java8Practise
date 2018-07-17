package university.degreeModules;

public class DegreeModule {

    protected String degreeTopic;
    protected int credits;

    public DegreeModule(String degreeTopic, int credits) {
        this.degreeTopic = degreeTopic;
        this.credits = credits;
    }

    public DegreeModule(String degreeTopic) {
        this.degreeTopic = degreeTopic;
        this.credits = 50;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getDegreeTopic() {
        return this.degreeTopic;
    }
}
