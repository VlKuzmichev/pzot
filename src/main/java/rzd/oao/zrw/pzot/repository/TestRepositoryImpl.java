package rzd.oao.zrw.pzot.repository;

import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Test;

import java.util.List;

@Repository
public class TestRepositoryImpl implements TestRepository {
    private final CrudTestRepository testRepository;

    public TestRepositoryImpl(CrudTestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

    @Override
    public boolean delete(int id) {
        return testRepository.delete(id) != 0;
    }

    @Override
    public Test get(int id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Test getWithQuestions(int id) {
        return testRepository.getWithQuestions(id);
    }

    @Override
    public Test getWithUsers(int id) {
        return testRepository.getWithUsers(id);
    }

    @Override
    public Test getByName(String name) {
        return testRepository.getByName(name);
    }
}
