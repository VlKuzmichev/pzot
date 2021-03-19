package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.List;

@Repository("userGroupRepository")
public class UserGroupRepositoryImpl implements UserGroupRepository {
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    private final CrudUserGroupRepository crudUserGroupRepository;

    public UserGroupRepositoryImpl(CrudUserGroupRepository crudUserGroupRepository) {
        this.crudUserGroupRepository = crudUserGroupRepository;
    }

    @Override
    public UserGroup save(UserGroup userGroup) {
        return crudUserGroupRepository.save(userGroup);
    }

    @Override
    public boolean delete(int id) {
        return crudUserGroupRepository.delete(id) != 0;
    }

    @Override
    public UserGroup get(int id) {
        return crudUserGroupRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserGroup> getAll() {
        return crudUserGroupRepository.findAll(SORT_NAME);
    }

    @Override
    public UserGroup getByName(String name) {
        return crudUserGroupRepository.getByName(name);
    }
}
