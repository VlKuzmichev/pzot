package rzd.oao.zrw.pzot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.*;
import rzd.oao.zrw.pzot.service.AnswerService;
import rzd.oao.zrw.pzot.service.ResultService;
import rzd.oao.zrw.pzot.service.TestService;
import rzd.oao.zrw.pzot.service.UserService;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public abstract class AbstractResultController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResultService resultService;

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @Autowired
    private AnswerService answerService;


    public Question getNotAnsweredQuestionByTestId(int testId) {
        log.info("getNotAnsweredQuestionByTestId {}", testId);
        int userId = SecurityUtil.authUserId();
        return resultService.getNotAnsweredQuestion(userId, testId);
    }

    public Result create(Result result) {
        log.info("create {}", result);
        checkNew(result);
        return resultService.create(result);
    }

    public Quiz getTest(int testId) {
        log.info("getTest {}", testId);
        return testService.get(testId);
    }

    public User getUser() {
        int userId = SecurityUtil.authUserId();
        log.info("getUser {}", userId);
        return userService.get(userId);
    }

    public Answer getAnswer(int answerId) {
        log.info("getAnswer {}", answerId);
        return answerService.get(answerId);
    }

    public int getUserResultByTestId(int testId) {
        log.info("getUserResultByTestId {}", testId);
        int userId = SecurityUtil.authUserId();
        return resultService.getUserResult(userId, testId);
    }
}
