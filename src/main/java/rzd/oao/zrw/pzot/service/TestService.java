package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Test;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface TestService {
    Test create(Test test);

    void delete(int id) throws NotFoundException;

    void update(Test test);

    Test get(int id) throws NotFoundException;

    List<Test> getAll();

    Test getWithQuestions(int id) throws NotFoundException;

    Test getWithUsers(int id) throws NotFoundException;

    Test getByName(String name);

}
