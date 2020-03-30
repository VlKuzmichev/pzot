package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question create(Question question);

    void delete(int id) throws NotFoundException;

    void update(Question questionGroup);

    Question get(int id) throws NotFoundException;

    List<Question> getAll();

    List<Question> getWithoutTestQuestions(int testId);

    Question getWithAnswers(int id) throws NotFoundException;

    Question getWithTests(int id) throws NotFoundException;

    Question getByName(String name) throws NotFoundException;

}
