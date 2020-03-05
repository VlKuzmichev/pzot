package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.repository.AnswerRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer create(Answer answer) throws NotFoundException {
        return answerRepository.get(answer.getId()) == null ?
                answerRepository.save(answer) : null;
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
        Answer answer = answerRepository.get(id);
        if (answer == null) throw new NotFoundException("id=" + id);
        return answerRepository.get(id);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.getAll();
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
