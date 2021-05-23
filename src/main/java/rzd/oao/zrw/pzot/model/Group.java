package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "group_unique_name_idx")})
public class Group extends AbstractNamedEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_groups", joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

    public Group() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
