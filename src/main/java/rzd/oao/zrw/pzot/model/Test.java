package rzd.oao.zrw.pzot.model;

import java.util.List;

public class Test extends AbstractBaseEntity{
    private String name;
    private List<Question> questions;
    private List<UserGroup> userGroups;

    public Test() {
    }

    public Test(Integer id, String name, List<Question> questions, List<UserGroup> userGroups) {
        super(id);
        this.name = name;
        this.questions = questions;
        this.userGroups = userGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
