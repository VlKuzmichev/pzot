package rzd.oao.zrw.pzot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "users_unique_name_idx")})
public class User extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    protected String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_group_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private UserGroup group;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonIgnore
    private List<Group> studentGroups;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    // for update
    public User(User u) {
        this(u.getId(),
                u.getName(),
                u.getPassword(),
                u.getEmail(),
                u.getFullName(),
                u.getGroup(),
                u.getRoles());
    }

    public User(Integer id,
                String name,
                String password,
                String email,
                String fullName,
                UserGroup group,
                Role role,
                Role... roles) {
        this(id,
                name,
                password,
                email,
                fullName,
                group,
                EnumSet.of(role, roles));
    }


    public User(Integer id,
                String name,
                String password,
                String email,
                String fullName,
                UserGroup group,
                Set<Role> roles) {
        super(id);
        this.name = name;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.group = group;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ?
                EnumSet.noneOf(Role.class) :
                EnumSet.copyOf(roles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return Objects.equals(this.getId(), that.getId());
    }

    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
