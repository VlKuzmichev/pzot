package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.repository.QuestionRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) throws NotFoundException {
        Assert.notNull(question, "answer must not be null");
        return questionRepository.save(question);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!questionRepository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(Question questionGroup) {
        questionRepository.save(questionGroup);
    }

    @Override
    public Question get(int id) throws NotFoundException {
        return checkNotFoundWithId(questionRepository.get(id), id);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getWithAnswers(int id) throws NotFoundException {
        return questionRepository.getWithAnswers(id);
    }

    @Override
    public Question getWithTests(int id) throws NotFoundException {
        return questionRepository.getWithTests(id);
    }

    @Override
    public Question getByName(String name) throws NotFoundException {
        Question question = questionRepository.getByName(name);
        if (question == null) throw new NotFoundException("Name=" + name);
        return questionRepository.getByName(name);
    }
}
