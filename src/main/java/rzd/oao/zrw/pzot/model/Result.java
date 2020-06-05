package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "results", uniqueConstraints = {@UniqueConstraint(columnNames = {"answer_date", "user_id", "test_id", "question_id"},
        name = "results_idx")})
public class Result extends AbstractBaseEntity{

    @Column(name = "answer_date", nullable = false)
    private LocalDateTime answerDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "test_id", nullable = false)
    private Quiz test;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
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

}
