package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.repository.TestRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Quiz create(Quiz test) throws NotFoundException {
        Assert.notNull(test, "user must not be null");
        return testRepository.save(test);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!testRepository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(Quiz test) {
        testRepository.save(test);
    }

    @Override
    public Quiz get(int id) throws NotFoundException {
        return checkNotFoundWithId(testRepository.get(id), id);
    }

    @Override
    public List<Quiz> getAll() {
        return testRepository.getAll();
    }

    @Override
    public Quiz getWithQuestions(int id) throws NotFoundException {
        return testRepository.getWithQuestions(id);
    }

    @Override
    public Quiz getWithUsers(int id) throws NotFoundException {
        return testRepository.getWithUsers(id);
    }

    @Override
    public Quiz getByName(String name) {
        return testRepository.getByName(name);
    }

    @Transactional
    @Override
    public void addUser(int testId, User user) {
        Quiz test = getWithUsers(testId);
        test.addUser(user);
        testRepository.save(test);
    }

    @Transactional
    @Override
    public void removeUser(int testId, User user) {
        Quiz test = getWithUsers(testId);
        test.removeUser(user);
        testRepository.save(test);
    }

}
