package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.repository.AnswerRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer create(Answer answer) throws NotFoundException {
        Assert.notNull(answer, "answer must not be null");
        return answerRepository.save(answer);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!answerRepository.delete(id)) throw new NotFoundException("id=" + id);
    }

    @Override
    public void update(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Answer get(int id) throws NotFoundException {
        return checkNotFoundWithId(answerRepository.get(id), id);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.getAll();
    }

    @Override
    public List<Answer> getAllByQuestion(int id) throws NotFoundException {
        return answerRepository.getAllByQuestion(id);
    }

    @Override
    public Answer getWithQuestion(int id) throws NotFoundException {
        return answerRepository.getWithQuestion(id);
    }

    @Override
    public Answer getByName(String name) {
        return answerRepository.getByName(name);
    }
}
