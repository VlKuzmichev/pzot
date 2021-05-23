package rzd.oao.zrw.pzot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Group;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.repository.StudentGroupRepository;
import rzd.oao.zrw.pzot.repository.UserGroupRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

@Transactional(readOnly = true)
@Service("studentGroupService")
public class StudentGroupServiceImpl implements StudentGroupService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final StudentGroupRepository studentGroupRepository;

    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @Transactional
    @Override
    public Group create(Group studentGroup) {
        Assert.notNull(studentGroup, "userGroup must not be null");
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!studentGroupRepository.delete(id)) throw new NotFoundException("Not found with id=" + id);
    }

    @Override
    public void update(Group studentGroup) {
        studentGroupRepository.save(studentGroup);

    }

    @Override
    public Group get(int id) throws NotFoundException {
        return studentGroupRepository.get(id);//checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Group> getAll() {
        log.info("get userGroups");
        return studentGroupRepository.getAll();
    }

    @Override
    public Group getByName(String name) {
        return studentGroupRepository.getByName(name);
    }
}
