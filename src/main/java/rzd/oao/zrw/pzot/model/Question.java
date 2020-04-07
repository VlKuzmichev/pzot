package rzd.oao.zrw.pzot.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "questions", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "question_unique_name_idx")})
public class Question extends AbstractBaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_group_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private QuestionGroup questionGroup;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "questions")
    private List<Quiz> tests;

    public Question() {
    }

    public Question(Integer id, String name, QuestionGroup questionGroup) {
        super(id, name);
        this.questionGroup = questionGroup;
    }

    public Question(Question q) {
        this(q.getId(), q.getName(), q.getQuestionGroup());
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

    public List<Quiz> getTests() {
        return tests;
    }

    public void setTests(List<Quiz> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questionGroup=" + questionGroup +
                '}';
    }
}
