package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.service.AnswerService;
import rzd.oao.zrw.pzot.service.QuestionService;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public class AbstractAnswerController {
    @Autowired
    private AnswerService service;

    @Autowired
    private QuestionService questionService;

    public Question getQuestionById(int id) {
//        log.info("getAll");
        return questionService.get(id);
    }

    public List<Answer> getAll() {
//        log.info("getAll");
        return service.getAll();
    }

    public List<Answer> getAllByQuestion(int id) {
//        log.info("getAll");
        return service.getAllByQuestion(id);
    }

    public Answer get(int id) {
//        log.info("get {}", id);
        return service.get(id);
    }

    public Answer create(Answer answer) {
//        log.info("create {}", user);
        checkNew(answer);
        return service.create(answer);
    }

    public void delete(int id) {
//        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Answer answer, int id) {
//        log.info("update {} with id={}", user, id);
        assureIdConsistent(answer, id);
        service.update(answer);
    }

}
