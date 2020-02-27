package rzd.oao.zrw.pzot.model;

public class Answer extends AbstractBaseEntity {
    private String text;
    private Boolean truth;
    private Question question;

    public Answer() {
    }

    public Answer(Integer id, String text, Boolean truth, Question question) {
        super(id);
        this.text = text;
        this.truth = truth;
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getTruth() {
        return truth;
    }

    public void setTruth(Boolean truth) {
        this.truth = truth;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", truth=" + truth +
                ", question=" + question +
                '}';
    }
}
