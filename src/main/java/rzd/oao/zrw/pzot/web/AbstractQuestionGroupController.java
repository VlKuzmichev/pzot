package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.service.QuestionGroupService;
import rzd.oao.zrw.pzot.service.UserGroupService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public abstract class AbstractQuestionGroupController {
//    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private QuestionGroupService service;

    public List<QuestionGroup> getAll() {
//        log.info("getAll");
        return service.getAll();
    }

    public QuestionGroup get(int id) {
//        log.info("get {}", id);
        return service.get(id);
    }

    public QuestionGroup create(QuestionGroup questionGroup) {
//        log.info("create {}", user);
        checkNew(questionGroup);
        return service.create(questionGroup);
    }

    public void delete(int id) {
//        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(QuestionGroup questionGroup, int id) {
//        log.info("update {} with id={}", user, id);
        assureIdConsistent(questionGroup, id);
        service.update(questionGroup);
    }

}
