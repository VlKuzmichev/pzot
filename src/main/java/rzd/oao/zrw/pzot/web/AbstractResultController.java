package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.*;
import rzd.oao.zrw.pzot.service.*;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public abstract class AbstractResultController {
    //protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ResultService resultService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestService testService;

    @Autowired
    private AnswerService answerService;


    public Question getNotAnsweredQuestion(int userId, int testId) {
        return resultService.getNotAnsweredQuestion(userId, testId);
    }

    public Result create(Result result) {
//        log.info("create {}", user);
        checkNew(result);
        return resultService.create(result);
    }

    public Quiz getTest(int testId) {
////        log.info("create {}", user);
        return testService.get(testId);
    }

    public User getUser(int userId) {
////        log.info("create {}", user);
        return userService.get(userId);
    }

    public Answer getAnswer(int answerId) {
////        log.info("create {}", user);
        return answerService.get(answerId);
    }

}
