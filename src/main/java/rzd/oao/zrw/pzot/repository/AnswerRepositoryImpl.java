package rzd.oao.zrw.pzot.repository;

import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Answer;

import java.util.List;

@Repository
public class AnswerRepositoryImpl implements AnswerRepository {

    private final CrudAnswerRepository answerRepository;

    public AnswerRepositoryImpl(CrudAnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public boolean delete(int id) {
        return answerRepository.delete(id) != 0;
    }

    @Override
    public Answer get(int id) {
        return answerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getWithQuestion(int id) {
        return answerRepository.getWithQuestion(id);
    }

    @Override
    public Answer getByName(String name) {
        return answerRepository.getByName(name);
    }
}
