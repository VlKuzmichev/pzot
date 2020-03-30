package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface TestService {
    Quiz create(Quiz test);

    void delete(int id) throws NotFoundException;

    void update(Quiz test);

    Quiz get(int id) throws NotFoundException;

    List<Quiz> getAll();

    Quiz getWithQuestions(int id) throws NotFoundException;

    Quiz getWithUsers(int id) throws NotFoundException;

    Quiz getByName(String name);

    void addUser(int testId, User user);

    void removeUser(int testId, User user);

    void addQuestion(int testId, Question question);

    void removeQuestion(int testId, Question question);

}
