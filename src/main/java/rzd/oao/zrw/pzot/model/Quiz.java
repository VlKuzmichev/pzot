package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tests", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "test_unique_name_idx")})
public class Quiz extends AbstractBaseEntity {
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "test_statuses", joinColumns = @JoinColumn(name = "test_id"))
    @Column(name = "status")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Status> status;
    @Column(name = "attempt")
    private Integer attempt;
    @Column(name = "max_attempts")
    private Integer maxAttempts;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tests_questions", joinColumns = {@JoinColumn(name = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")})
    private List<Question> questions;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tests")
    private List<User> users;

    public Quiz() {
    }

    public Quiz(Integer id, String name, Date startDate, Date endDate, Set<Status> status, Integer attempt, Integer maxAttempts) {
        super(id, name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.attempt = attempt;
        this.maxAttempts = maxAttempts;
    }

    public Quiz(Integer id, String name, Date startDate, Date endDate, Status status, Integer attempt, Integer maxAttempts) {
        this(id, name, startDate, endDate, EnumSet.of(status), attempt, maxAttempts);
    }

    public Quiz(Quiz q) {
        this(q.getId(), q.getName(), q.getStartDate(), q.getEndDate(), q.getStatus(), q.getAttempt(), q.getMaxAttempts());
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Status> getStatus() {
        return status;
    }

    public void setStatus(Set<Status> status) {
        this.status = status;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", attempt=" + attempt +
                ", maxAttempts=" + maxAttempts +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
