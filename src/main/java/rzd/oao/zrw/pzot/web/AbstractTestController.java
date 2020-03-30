package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.service.QuestionService;
import rzd.oao.zrw.pzot.service.TestService;
import rzd.oao.zrw.pzot.service.UserService;

import java.util.List;
import java.util.Set;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public class AbstractTestController {
//    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestService service;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    public List<Quiz> getAll() {
//        log.info("getAll");
        return service.getAll();
    }

    public Quiz get(int id) {
//        log.info("get {}", id);
        return service.get(id);
    }

    public Quiz create(Quiz test) {
//        log.info("create {}", user);
        checkNew(test);
        return service.create(test);
    }

    public void delete(int id) {
//        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Quiz test, int id) {
//        log.info("update {} with id={}", user, id);
        assureIdConsistent(test, id);
        service.update(test);
    }

    public Quiz getWithUsers(int testId) {
//        log.info("update {} with id={}", user, id);
        return service.getWithUsers(testId);
    }

    public Quiz getWithQuestions(int testId) {
//        log.info("update {} with id={}", user, id);
        return service.getWithQuestions(testId);
    }

    public List<User> getUsers(int testId) {
//        log.info("getAll");
        return userService.getWithoutTestUsers(testId);
    }

    public List<Question> getQuestions(int testId) {
//        log.info("getAll");
        return questionService.getWithoutTestQuestions(testId);
    }

    public User getUser(int id) {
//        log.info("getAll");
        return userService.get(id);
    }

    public Question getQuestion(int id) {
//        log.info("getAll");
        return questionService.get(id);
    }

    public void addQuestion(int testId, Question question) {
//        log.info("getAll");
        service.addQuestion(testId, question);
    }

    public void removeQuestion(int testId, Question question) {
//        log.info("getAll");
        service.removeQuestion(testId, question);
    }

    public void addUser(int testId, User user) {
//        log.info("getAll");
        service.addUser(testId, user);
    }

    public void removeUser(int testId, User user) {
//        log.info("getAll");
        service.removeUser(testId, user);
    }
}
