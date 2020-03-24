package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.service.TestService;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public class AbstractTestController {
//    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestService service;

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

}
