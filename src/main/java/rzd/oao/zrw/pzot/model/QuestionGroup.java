package rzd.oao.zrw.pzot.model;

import java.util.List;

public class QuestionGroup extends AbstractBaseEntity {
    private List<Question> questions;

    public QuestionGroup() {
    }

    public QuestionGroup(Integer id, String name, List<Question> questions) {
        super(id, name);
        this.questions = questions;
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

    @Override
    public String toString() {
        return "QuestionGroup{" +
                "questions=" + questions +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
