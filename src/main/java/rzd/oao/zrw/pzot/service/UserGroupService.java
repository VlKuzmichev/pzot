package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface UserGroupService {
    UserGroup create(UserGroup userGroup);

    void delete(int id) throws NotFoundException;

    void update(UserGroup userGroup);

    UserGroup get(int id) throws NotFoundException;

    List<UserGroup> getAll();

    UserGroup getWithUsers(int id) throws NotFoundException;

    UserGroup getByName(String name);

}
