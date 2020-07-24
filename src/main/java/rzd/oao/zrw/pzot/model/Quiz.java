package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tests", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "test_unique_name_idx")})
public class Quiz extends AbstractNamedEntity {
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "test_statuses", joinColumns = @JoinColumn(name = "test_id"))
    @Column(name = "status")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Status> status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tests_questions", joinColumns = {@JoinColumn(name = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id")})
    private List<Question> questions;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tests_users", joinColumns = {@JoinColumn(name = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    private List<Result> results;

    public Quiz() {
    }

    public Quiz(Integer id, String name, LocalDateTime startDate, LocalDateTime endDate, Set<Status> status) {
        super(id, name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Quiz(Integer id, String name, LocalDateTime startDate, LocalDateTime endDate, Status status) {
        this(id, name, startDate, endDate, EnumSet.of(status));
    }

    public Quiz(Quiz q) {
        this(q.getId(), q.getName(), q.getStartDate(), q.getEndDate(), q.getStatus());
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Set<Status> getStatus() {
        return status;
    }

    public void setStatus(Set<Status> status) {
        this.status = status;
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

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void removeQuestion(Question question) {
        this.questions.remove(question);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
    @Override
    public String toString() {
        return "Quiz{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
