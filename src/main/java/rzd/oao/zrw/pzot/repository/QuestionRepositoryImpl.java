package rzd.oao.zrw.pzot.repository;

import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Question;

import java.util.List;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final CrudQuestionRepository questionRepository;

    public QuestionRepositoryImpl(CrudQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public boolean delete(int id) {
        return questionRepository.delete(id) != 0;
    }

    @Override
    public Question get(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getWithAnswers(int id) {
        return questionRepository.getWithAnswers(id);
    }

    @Override
    public Question getWithTests(int id) {
        return questionRepository.getWithTests(id);
    }

    @Override
    public Question getByName(String name) {
        return questionRepository.getByName(name);
    }
}
