package rzd.oao.zrw.pzot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "user_group_unique_name_idx")})
public class UserGroup extends AbstractNamedEntity {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @JsonIgnore
    private List<User> users;

    public UserGroup() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
