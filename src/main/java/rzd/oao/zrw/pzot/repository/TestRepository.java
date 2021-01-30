package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.Quiz;

import java.util.List;

public interface TestRepository {
    Quiz save(Quiz test);

    // false if not found
    boolean delete(int id);

    // null if not found
    Quiz get(int id);

    List<Quiz> getAll();

    // null if not found
    Quiz getWithQuestions(int id);

    // null if not found
    Quiz getWithUsers(int id);

    // null if not found
    Quiz getByName(String name);

}
