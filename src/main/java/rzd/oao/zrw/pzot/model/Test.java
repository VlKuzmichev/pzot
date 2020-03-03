package rzd.oao.zrw.pzot.model;

import java.util.Date;
import java.util.List;

public class Test extends AbstractBaseEntity{
    private Date startDate;
    private Date endDate;
    private Status status;
    private Integer attempt;
    private Integer maxAttempts;
    private List<Question> questions;
    private List<User> users;

    public Test() {
    }

    public Test(Integer id, String name, Date startDate, Date endDate, Status status, Integer attempt, Integer maxAttempts) {
        super(id, name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.attempt = attempt;
        this.maxAttempts = maxAttempts;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
        return "Test{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", attempt=" + attempt +
                ", maxAttempts=" + maxAttempts +
                ", questions=" + questions +
                ", users=" + users +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
