package rzd.oao.zrw.pzot.repository;


import rzd.oao.zrw.pzot.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    List<User> getAll();

    // null if not found
//    User getByName(String name);

}
