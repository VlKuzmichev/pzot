package rzd.oao.zrw.pzot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;
import rzd.oao.zrw.pzot.web.AuthorizedUser;
import rzd.oao.zrw.pzot.web.SecurityUtil;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;
    private final TestService testService;

    public UserServiceImpl(UserRepository repository, TestService testService) {
        this.repository = repository;
        this.testService = testService;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(User user) {
        repository.save(user);
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
}
