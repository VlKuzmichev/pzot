package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.repository.UserGroupRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository userGroupRepository;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public UserGroup create(UserGroup userGroup) {
        return userGroupRepository.get(userGroup.getId()) == null ?
                userGroupRepository.save(userGroup) : null;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!userGroupRepository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }

    @Override
    public UserGroup get(int id) throws NotFoundException {
        UserGroup userGroup = userGroupRepository.get(id);
        if (userGroup == null) throw new NotFoundException("id=" + id);
        return userGroupRepository.get(id);
    }

    @Override
    public List<UserGroup> getAll() {
        return userGroupRepository.getAll();
    }

    @Override
    public UserGroup getWithUsers(int id) throws NotFoundException {
        return userGroupRepository.getWithUsers(id);
    }

    @Override
    public UserGroup getByName(String name) {
        UserGroup userGroup = userGroupRepository.getByName(name);
        if (userGroup == null) throw new NotFoundException("Name=" + name);
        return userGroupRepository.getByName(name);
    }
}
