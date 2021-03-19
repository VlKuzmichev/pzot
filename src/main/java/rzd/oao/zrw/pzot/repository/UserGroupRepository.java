package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.List;

public interface UserGroupRepository {
    UserGroup save(UserGroup userGroup);

    // false if not found
    boolean delete(int id);

    // null if not found
    UserGroup get(int id);

    List<UserGroup> getAll();

    // null if not found
    UserGroup getByName(String name);

}
