package rzd.oao.zrw.pzot.repository;

import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Group;
import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.List;

public interface StudentGroupRepository {
    Group save(Group studentGroup);

    // false if not found
    boolean delete(int id);

    // null if not found
    Group get(int id);

    List<Group> getAll();

    // null if not found
    Group getByName(String name);

}
