package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "results", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "test_id", "question_id"},
        name = "results_idx")})
public class Result extends AbstractBaseEntity {

    @Column(name = "completion_date", nullable = false)
    private LocalDateTime completionDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id", nullable = false)
    private Quiz test;

    public Result() {
    }

    public Result(LocalDateTime completionDate, User user, Quiz test) {
        this.completionDate = completionDate;
        this.user = user;
        this.test = test;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime answerDate) {
        this.completionDate = answerDate;
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

}