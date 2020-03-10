package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.Question;

import java.util.List;

public interface QuestionRepository {
    Question save(Question question);

    // false if not found
    boolean delete(int id);

    // null if not found
    Question get(int id);

    List<Question> getAll();

    // null if not found
    Question getWithAnswers(int id);

    // null if not found
    Question getWithTests(int id);

    // null if not found
    Question getByName(String name);

}
