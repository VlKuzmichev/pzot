package rzd.oao.zrw.pzot.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "question_unique_name_idx")})
public class Question extends AbstractBaseEntity{
    @Column(name = "answered", nullable = false)
    private Boolean answered;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_group_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private QuestionGroup questionGroup;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "questions")
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
