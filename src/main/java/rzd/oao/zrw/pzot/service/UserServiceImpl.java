package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
//        return repository.get(user.getId()) == null ? repository.save(user) : null;
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
//        User user = repository.get(id);
//        if (id == null) throw new NotFoundException("id=" + id);
//        return repository.get(id);
        return checkNotFoundWithId(repository.get(id), id);
    }

//    @Override
//    public User getByEmail(String email) throws NotFoundException {
//        User user = repository.getByEmail(email);
//        if (user == null) throw new NotFoundException("Email=" + email);
//        return repository.getByEmail(email);
//    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
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
}
