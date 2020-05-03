package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "user_group_unique_name_idx")})
public class UserGroup extends AbstractNamedEntity {

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userGroups")
    private List<User> users;

    public UserGroup() {
    }

    // for update
    public UserGroup(UserGroup ug) {
        this(ug.getId(), ug.getName());
    }

    public UserGroup(Integer id, String name) {
        super(id, name);
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
                "id=" + id +
                "name='" + name + '\'' +
                '}';
    }
}
