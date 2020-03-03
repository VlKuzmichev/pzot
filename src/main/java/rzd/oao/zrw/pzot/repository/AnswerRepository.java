package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.Answer;

import java.util.List;

public interface AnswerRepository {
    Answer save(Answer answer);

    // false if not found
    boolean delete(int id);

    // null if not found
    Answer get(int id);

    List<Answer> getAll();

    // null if not found
    Answer getWithQuestion(int id);

    // null if not found
    Answer getByName(String name);

}
