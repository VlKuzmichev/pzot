package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "results", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "test_id", "question_id"},
        name = "results_idx")})
public class Result extends AbstractBaseEntity {

    @Column(name = "answer_date", nullable = false)
    private LocalDateTime answerDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id", nullable = false)
    private Quiz test;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "answer_id", nullable = false)
    private Answer answer;

    public Result() {
    }

    public Result(LocalDateTime answerDate, User user, Quiz test, Question question, Answer answer) {
        this.answerDate = answerDate;
        this.user = user;
        this.test = test;
        this.question = question;
        this.answer = answer;
    }

    public LocalDateTime getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(LocalDateTime answerDate) {
        this.answerDate = answerDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getTest() {
        return test;
    }

    public void setTest(Quiz test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}