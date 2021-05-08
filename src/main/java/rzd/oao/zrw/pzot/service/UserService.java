package rzd.oao.zrw.pzot.service;



import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    void update(User user);

    User get(int id) throws NotFoundException;

    List<User> getAll();

    User getByName(String name);

//    void removeRole(Role role, int userId);
//
//    void addRole(Role role, int userId);

//    Set<Role> getRolesForAdd(int userId);
}
