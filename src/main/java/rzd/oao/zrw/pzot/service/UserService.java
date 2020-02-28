package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void update(User user);

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    User getWithUserGroups(int id) throws NotFoundException;

    User getByName(String name);
}
