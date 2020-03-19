package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.service.AnswerService;
import rzd.oao.zrw.pzot.service.QuestionGroupService;
import rzd.oao.zrw.pzot.service.QuestionService;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public class AbstractQuestionController {
//    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuestionService service;

    @Autowired
    private QuestionGroupService questionGroupService;

    public QuestionGroup getQuestion(int id){
        return questionGroupService.get(id);
    }

    public List<QuestionGroup> getAllQuestionsGroups() {
        return questionGroupService.getAll();
    }
    public Question getQuestionById(int id) {
//        log.info("getAll");
        return service.get(id);
    }

    public List<Question> getAll() {
//        log.info("getAll");
        return service.getAll();
    }

    public Question get(int id) {
//        log.info("get {}", id);
        return service.get(id);
    }

    public Question create(Question question) {
//        log.info("create {}", user);
        checkNew(question);
        return service.create(question);
    }

    public void delete(int id) {
//        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(Question question, int id) {
//        log.info("update {} with id={}", user, id);
        assureIdConsistent(question, id);
        service.update(question);
    }
}
