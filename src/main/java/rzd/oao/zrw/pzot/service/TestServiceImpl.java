package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import rzd.oao.zrw.pzot.model.Test;
import rzd.oao.zrw.pzot.repository.TestRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test create(Test test) throws NotFoundException {
        return testRepository.get(test.getId()) == null ?
                testRepository.save(test) : null;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!testRepository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(Test test) {
        testRepository.save(test);
    }

    @Override
    public Test get(int id) throws NotFoundException {
        Test test = testRepository.get(id);
        if (test == null) throw new NotFoundException("id=" + id);
        return testRepository.get(id);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.getAll();
    }

    @Override
    public Test getWithQuestions(int id) throws NotFoundException {
        return testRepository.getWithQuestions(id);
    }

    @Override
    public Test getWithUsers(int id) throws NotFoundException {
        return testRepository.getWithUsers(id);
    }

    @Override
    public Test getByName(String name) {
        return testRepository.getByName(name);
    }
}
