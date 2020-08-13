package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    void update(User user);

    User get(int id) throws NotFoundException;

    List<User> getAll();

    List<User> getWithoutTestUsers(int testId);

    User getWithUserGroups(int id) throws NotFoundException;

    User getByName(String name);

    User getWithTests() throws NotFoundException;

    List<Quiz> getUserTests();

}
