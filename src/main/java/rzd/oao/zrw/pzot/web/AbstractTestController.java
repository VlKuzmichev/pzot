package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.service.QuestionService;
import rzd.oao.zrw.pzot.service.ResultService;
import rzd.oao.zrw.pzot.service.TestService;
import rzd.oao.zrw.pzot.service.UserService;

import java.util.List;
import java.util.Map;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public abstract class AbstractTestController {
    //protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ResultService resultService;

    public List<Quiz> getAll() {
//        log.info("getAll");
        return testService.getAll();
    }

    public Quiz get(int id) {
//        log.info("get {}", id);
        return testService.get(id);
    }

    public Quiz create(Quiz test) {
//        log.info("create {}", user);
        checkNew(test);
        return testService.create(test);
    }

    public void delete(int id) {
//        log.info("delete {}", id);
        testService.delete(id);
    }

    public void update(Quiz test, int id) {
//        log.info("update {} with id={}", user, id);
        assureIdConsistent(test, id);
        testService.update(test);
    }

    public Quiz getWithUsers(int testId) {
//        log.info("update {} with id={}", user, id);
        return testService.getWithUsers(testId);
    }

    public Quiz getWithQuestions(int testId) {
//        log.info("update {} with id={}", user, id);
        return testService.getWithQuestions(testId);
    }

    public List<User> getWithoutTestUsers(int testId) {
//        log.info("getAll");
        return userService.getWithoutTestUsers(testId);
    }

    public List<Question> getWithoutTestQuestions(int testId) {
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

        testService.addQuestion(testId, question);
    }

    public void removeQuestion(int testId, Question question) {
//        log.info("getAll");
        testService.removeQuestion(testId, question);
    }

    public void addUser(int testId, User user) {
//        log.info("getAll");
        testService.addUser(testId, user);
    }

    public void removeUser(int testId, User user) {
//        log.info("getAll");
        testService.removeUser(testId, user);
    }

    public Map<User, Integer> getAllResults(int testId) {
//        log.info("getAll");
        return resultService.getAllResultsByTest(testId);
    }

    public Map<Integer, Integer> getAllUsersTestStatuses(int testId) {
//        log.info("getAll");
        return resultService.getAllUsersTestStatuses(testId);
    }

}
