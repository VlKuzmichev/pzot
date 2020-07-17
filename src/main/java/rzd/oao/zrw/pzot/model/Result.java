package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table(name = "results", uniqueConstraints = {@UniqueConstraint(columnNames = {"answer_date", "user_id", "test_id", "question_id"},
        @Table(name = "results", uniqueConstraints = {@UniqueConstraint(columnNames = {"answer_date"},
        name = "results_idx")})
public class Result extends AbstractBaseEntity {

    @Column(name = "answer_date", nullable = false)
    private LocalDateTime answerDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "results_users", joinColumns = {@JoinColumn(name = "result_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "results_tests", joinColumns = {@JoinColumn(name = "result_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id")})
    private List<Quiz> tests;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "results_questions", joinColumns = {@JoinColumn(name = "result_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")})
    private List<Question> questions;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "results_answers", joinColumns = {@JoinColumn(name = "result_id")},
            inverseJoinColumns = {@JoinColumn(name = "answer_id")})
    private List<Answer> answers;

    public Result() {
    }

    public Result(Integer id, LocalDateTime answerDate) {
        super(id);
        this.answerDate = answerDate;
    }

//    public Result(LocalDateTime answerDate, User user, Quiz test, Question question, Answer answer) {
//        this.answerDate = answerDate;
//        this.user = user;
//        this.test = test;
//        this.question = question;
//        this.answer = answer;
//    }

}
