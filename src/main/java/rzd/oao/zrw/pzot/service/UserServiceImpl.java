package rzd.oao.zrw.pzot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.Role;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;
import rzd.oao.zrw.pzot.web.AuthorizedUser;
import rzd.oao.zrw.pzot.web.SecurityUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static rzd.oao.zrw.pzot.util.UserUtil.prepareToSave;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    private final TestService testService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, TestService testService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.testService = testService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) throw new NotFoundException("Not found with id=" + id);
    }

    @Override
    public void update(User user) {
        repository.save(prepareToSave(user, passwordEncoder));
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public List<User> getWithoutTestUsers(int testId) {
        List<User> users = repository.getAll();
        Quiz testWithUsers = testService.getWithUsers(testId);
        if (testWithUsers != null)
            users.removeAll(testWithUsers.getUsers());
        // users.removeAll(testService.getWithUsers(testId).getUsers());
        return users;
    }

    @Override
    public User getWithUserGroups(int id) throws NotFoundException {
        return repository.getWithUserGroups(id);
    }

    @Override
    public User getByName(String name) {
        User user = repository.getByName(name);
        if (user == null) throw new NotFoundException("Name=" + name);
        return repository.getByName(name);
    }

    @Override
    public User getWithTests() throws NotFoundException {
        int userId = SecurityUtil.authUserId();
        return checkNotFoundWithId(repository.getWithTests(userId), userId);
    }

    @Override
    public List<Quiz> getUserTests() {
        int userId = SecurityUtil.authUserId();
        User user = repository.getWithTests(userId);
        if (user == null) return null;
        return user.getTests();
    }

    @Override
    public AuthorizedUser loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repository.getByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User " + name + " is not found");
        }

        return new AuthorizedUser(user);
    }

    @Override
    public void removeRole(Role role, int userId) {
        User user = repository.get(userId);
        user.getRoles().remove(role);
        repository.save(user);
    }

    @Override
    public void addRole(Role role, int userId) {
        User user = repository.get(userId);
        user.getRoles().add(role);
        repository.save(user);
    }

    @Override
    public Set<Role> getRolesForAdd(int userId) {
        Set<Role> userRoles = repository.get(userId).getRoles();
        Set<Role> allRoles = new HashSet<>();
        allRoles.addAll(Arrays.asList(Role.class.getEnumConstants()));
        allRoles.removeAll(userRoles);
        return allRoles;
    }
}
