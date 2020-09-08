package rzd.oao.zrw.pzot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.service.AnswerService;
import rzd.oao.zrw.pzot.service.QuestionService;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public class AbstractAnswerController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AnswerService service;

    @Autowired
    private QuestionService questionService;

    public Question getQuestionById(int id) {
        log.info("get question {}", id);
        return questionService.get(id);
    }

    public List<Answer> getAll() {
        log.info("get all answers");
        return service.getAll();
    }

    public List<Answer> getAllByQuestion(int id) {
        log.info("get all answers by question {}", id);
        return service.getAllByQuestion(id);
    }

    public Answer get(int id) {
        log.info("get answer {}", id);
        return service.get(id);
    }

    public Answer create(Answer answer) {
        log.info("create {}", answer);
        checkNew(answer);
        return service.create(answer);
    }

    public void delete(int id) {
        log.info("remove answer {}", id);
        service.delete(id);
    }

    public void update(Answer answer, int id) {
        log.info("update {} with id={}", answer, id);
        assureIdConsistent(answer, id);
        service.update(answer);
    }

}
