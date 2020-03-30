package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.repository.QuestionRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository repository;
    private final TestService testService;

    public QuestionServiceImpl(QuestionRepository questionRepository, TestService testService) {
        this.repository = questionRepository;
        this.testService = testService;
    }

    @Override
    public Question create(Question question) throws NotFoundException {
        Assert.notNull(question, "answer must not be null");
        return repository.save(question);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(Question questionGroup) {
        repository.save(questionGroup);
    }

    @Override
    public Question get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Question> getAll() {
        return repository.getAll();
    }

    @Transactional
    @Override
    public List<Question> getWithoutTestQuestions(int testId) {
        List<Question> questions = repository.getAll();
        questions.removeAll(testService.getWithQuestions(testId).getQuestions());
        return questions;
    }

    @Override
    public Question getWithAnswers(int id) throws NotFoundException {
        return repository.getWithAnswers(id);
    }

    @Override
    public Question getWithTests(int id) throws NotFoundException {
        return repository.getWithTests(id);
    }

    @Override
    public Question getByName(String name) throws NotFoundException {
        Question question = repository.getByName(name);
        if (question == null) throw new NotFoundException("Name=" + name);
        return repository.getByName(name);
    }
}
