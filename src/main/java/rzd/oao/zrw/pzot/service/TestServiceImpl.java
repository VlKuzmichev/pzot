package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.repository.TestRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
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
        Assert.notNull(test, "test must not be null");
        return testRepository.save(test);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!testRepository.delete(id)) throw new NotFoundException("Not found with id=" + id);
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
        if (test == null) {
            test = get(testId);
            List<User> newUsers = new ArrayList<>();
            newUsers.add(user);
            test.setUsers(newUsers);
        } else
            test.addUser(user);
        testRepository.save(test);
    }

    @Transactional
    @Override
    public void removeUser(int testId, User user) throws NotFoundException {
        Quiz test = getWithUsers(testId);
        test.removeUser(user);
        testRepository.save(test);
    }

    @Transactional
    @Override
    public void addQuestion(int testId, Question question) {
        Quiz test = getWithQuestions(testId);
        if (test == null) {
            test = get(testId);
            List<Question> newQuestions = new ArrayList<>();
            newQuestions.add(question);
            test.setQuestions(newQuestions);
        } else
            test.addQuestion(question);
        testRepository.save(test);
    }

    @Override
    public void removeQuestion(int testId, Question question) throws NotFoundException {
        Quiz test = getWithQuestions(testId);
        test.removeQuestion(question);
        testRepository.save(test);
    }
}
