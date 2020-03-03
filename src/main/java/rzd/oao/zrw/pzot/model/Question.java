package rzd.oao.zrw.pzot.model;

import java.util.List;

public class Question extends AbstractBaseEntity{
    private Boolean answered;
    private QuestionGroup questionGroup;
    private List<Answer> answers;
    private List<Test> tests;

    public Question() {
    }

    public Question(Integer id, String name, Boolean answered) {
        super(id, name);
        this.answered = answered;
    }

    public Boolean getAnswered() {
        return answered;
    }

    public void setAnswered(Boolean answered) {
        this.answered = answered;
    }

    public QuestionGroup getQuestionGroup() {
        return questionGroup;
    }

    public void setQuestionGroup(QuestionGroup questionGroup) {
        this.questionGroup = questionGroup;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Question{" +
                "answered=" + answered +
                ", questionGroup=" + questionGroup +
                ", answers=" + answers +
                ", tests=" + tests +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
