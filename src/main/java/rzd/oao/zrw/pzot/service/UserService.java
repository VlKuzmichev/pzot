package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import rzd.oao.zrw.pzot.model.User;

import java.util.List;

@Service
public interface UserService {
    User create(User user);

    void update(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

    // null if not found
    User getWithUserGroups(int id);

    // null if not found
    User getByName(String name);
}
