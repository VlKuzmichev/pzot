package rzd.oao.zrw.pzot.model;

import java.util.List;

public class Question extends AbstractBaseEntity{
    private String text;
    private int rightAnswers;
    private QuestionGroup questionGroup;
    private List<Answer> answers;

    public Question() {
    }

    public Question(Integer id, String text, int rightAnswers, QuestionGroup questionGroup, List<Answer> answers) {
        super(id);
        this.text = text;
        this.rightAnswers = rightAnswers;
        this.questionGroup = questionGroup;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(int rightAnswers) {
        this.rightAnswers = rightAnswers;
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

//    @Override
//    public String toString() {
//        return "Question{" +
//                "id=" + id +
//                ", text='" + text + '\'' +
//                ", rightAnswers=" + rightAnswers +
//                ", questionGroup=" + questionGroup +
//                ", answers=" + answers +
//                '}';
//    }

}
