package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    // List because possibly many users by one email
//    User getByEmail(String email);

    List<User> getAll();

    // null if not found
    User getWithUserGroups(int id);

    // null if not found
    User getByName(String name);
}
