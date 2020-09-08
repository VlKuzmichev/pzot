package rzd.oao.zrw.pzot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ResultService resultService;

    public List<Quiz> getAll() {
        log.info("getAll");
        return testService.getAll();
    }

    public Quiz get(int id) {
        log.info("get {}", id);
        return testService.get(id);
    }

    public Quiz create(Quiz test) {
        log.info("create {}", test);
        checkNew(test);
        return testService.create(test);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        testService.delete(id);
    }

    public void update(Quiz test, int id) {
        log.info("update {} with id={}", test, id);
        assureIdConsistent(test, id);
        testService.update(test);
    }

    public Quiz getWithUsersByTestId(int testId) {
        log.info("getWithUsersByTestId {}", testId);
        return testService.getWithUsers(testId);
    }

    public Quiz getWithQuestionsByTestId(int testId) {
        log.info("getWithQuestionsByTestId {}", testId);
        return testService.getWithQuestions(testId);
    }

    public List<User> getWithoutTestUsersByTestId(int testId) {
        log.info("getWithoutTestUsersByTestId {}", testId);
        return userService.getWithoutTestUsers(testId);
    }

    public List<Question> getWithoutTestQuestionsByTestId(int testId) {
        log.info("getWithoutTestQuestionsByTestId {}", testId);
        return questionService.getWithoutTestQuestions(testId);
    }

    public User getUser(int id) {
        log.info("getUser {}", id);
        return userService.get(id);
    }

    public Question getQuestion(int id) {
        log.info("getQuestion {}", id);
        return questionService.get(id);
    }

    public void addQuestion(int testId, Question question) {
        log.info("addQuestion {} by test id={}", question, testId);
        testService.addQuestion(testId, question);
    }

    public void removeQuestion(int testId, Question question) {
        log.info("removeQuestion {} by test id={}", question, testId);
        testService.removeQuestion(testId, question);
    }

    public void addUser(int testId, User user) {
        log.info("addUser {} by test id={}", user, testId);
        testService.addUser(testId, user);
    }

    public void removeUser(int testId, User user) {
        log.info("removeUser {} by test id={}", user, testId);
        testService.removeUser(testId, user);
    }

    public Map<User, Integer> getAllResultsByTestId(int testId) {
        log.info("getAllResultsByTestId {}", testId);
        return resultService.getAllResultsByTest(testId);
    }

    public Map<Integer, Integer> getAllUsersTestStatusesByTestId(int testId) {
        log.info("getAllUsersTestStatusesByTestId {}", testId);
        return resultService.getAllUsersTestStatuses(testId);
    }

}
