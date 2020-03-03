package rzd.oao.zrw.pzot.model;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"},
        name = "users_unique_name_idx")})
public class User extends AbstractBaseEntity {
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_group_users", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<UserGroup> userGroups;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tests_users", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id")})
    private List<Test> tests;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getPassword(), u.getEmail(), u.getFullName(), u.getRoles());
    }

    public User(Integer id, String name, String password, String email, String fullName, Role role, Role... roles) {
        this(id, name, password, email, fullName, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String password, String email, String fullName, Set<Role> roles) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.roles = roles;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
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

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
