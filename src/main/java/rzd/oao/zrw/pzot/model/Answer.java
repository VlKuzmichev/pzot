package rzd.oao.zrw.pzot.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends AbstractBaseEntity {

    @Column(name = "truth", nullable = false)
    private Boolean truth;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    public Answer() {
    }

    public Answer(Integer id, String name, Boolean truth, Question question) {
        super(id, name);
        this.truth = truth;
        this.question = question;
    }

    public Answer(Answer a) {
        this(a.getId(), a.getName(), a.getTruth(), a.getQuestion());
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
                ", truth=" + truth +
                ", question=" + question +
                '}';
    }
}
