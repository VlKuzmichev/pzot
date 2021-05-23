package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Group;

import java.util.List;

@Repository("studentGroupRepository")
public class StudentGroupRepositoryImpl implements StudentGroupRepository {
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    private final CrudStudentGroupRepository crudStudentGroupRepository;

    public StudentGroupRepositoryImpl(CrudStudentGroupRepository crudStudentGroupRepository) {
        this.crudStudentGroupRepository = crudStudentGroupRepository;
    }

    @Override
    public Group save(Group studentGroup) {
        return crudStudentGroupRepository.save(studentGroup);
    }

    @Override
    public boolean delete(int id) {
        return crudStudentGroupRepository.delete(id) != 0;
    }

    @Override
    public Group get(int id) {
        return crudStudentGroupRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAll() {
        return crudStudentGroupRepository.findAll(SORT_NAME);
    }

    @Override
    public Group getByName(String name) {
        return crudStudentGroupRepository.getByName(name);
    }
}
