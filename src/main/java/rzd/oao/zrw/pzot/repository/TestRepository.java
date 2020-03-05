package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Test;

import java.util.List;

public interface TestRepository {
    Test save(Test test);

    // false if not found
    boolean delete(int id);

    // null if not found
    Test get(int id);

    List<Test> getAll();

    // null if not found
    Test getWithQuestions(int id);

    // null if not found
    Test getWithUsers(int id);

    // null if not found
    Test getByName(String name);

}
