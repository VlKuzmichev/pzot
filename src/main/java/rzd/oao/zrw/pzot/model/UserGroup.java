package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_groups", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "user_group_unique_name_idx")})
public class UserGroup extends AbstractBaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userGroups")
    private List<User> users;

    public UserGroup() {
    }

    public UserGroup(Integer id, String name, List<User> users) {
        super(id);
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
