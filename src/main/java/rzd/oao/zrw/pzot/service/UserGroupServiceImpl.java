package rzd.oao.zrw.pzot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.repository.UserGroupRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

@Transactional(readOnly = true)
@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService{
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final UserGroupRepository userGroupRepository;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Transactional
    @Override
    public UserGroup create(UserGroup userGroup) {
        Assert.notNull(userGroup, "userGroup must not be null");
        return userGroupRepository.save(userGroup);
    }

    @Transactional
    @Override
    public void delete(int id) throws NotFoundException {
        if (!userGroupRepository.delete(id)) throw new NotFoundException("Not found with id=" + id);
    }

    @Transactional
    @Override
    public void update(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }

    @Override
    public UserGroup get(int id) throws NotFoundException {
        return userGroupRepository.get(id);//checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<UserGroup> getAll() {
        log.info("get userGroups");
        return userGroupRepository.getAll();
    }

    @Override
    public UserGroup getByName(String name) throws NotFoundException {
        return userGroupRepository.getByName(name);
    }
}
