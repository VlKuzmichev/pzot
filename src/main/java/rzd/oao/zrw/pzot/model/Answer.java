package rzd.oao.zrw.pzot.model;

public class Answer extends AbstractBaseEntity {

    private Boolean checked;
    private Boolean truth;
    private Question question;

    public Answer() {
    }

    public Answer(Integer id, String name, Boolean checked, Boolean truth, Question question) {
        super(id, name);
        this.checked = checked;
        this.truth = truth;
        this.question = question;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
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
                ", name='" + name + '\'' +
                ", checked=" + checked +
                ", truth=" + truth +
                ", question=" + question +
                '}';
    }
}
