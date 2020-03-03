package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "question_group_unique_name_idx")})
public class QuestionGroup extends AbstractBaseEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionGroup")
    private List<Question> questions;

    public QuestionGroup() {
    }

    public QuestionGroup(Integer id, String name, List<Question> questions) {
        super(id, name);
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "QuestionGroup{" +
                "questions=" + questions +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
