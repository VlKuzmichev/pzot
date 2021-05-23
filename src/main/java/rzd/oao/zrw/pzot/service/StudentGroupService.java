package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Group;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface StudentGroupService {
    Group create(Group studentGroup);

    void delete(int id) throws NotFoundException;

    void update(Group studentGroup);

    Group get(int id) throws NotFoundException;

    List<Group> getAll();

    Group getByName(String name);

}
