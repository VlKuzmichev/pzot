package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.service.UserGroupService;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public class AbstractUserGroupController {
//    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserGroupService service;

    public List<UserGroup> getAll() {
//        log.info("getAll");
        return service.getAll();
    }

    public UserGroup get(int id) {
//        log.info("get {}", id);
        return service.get(id);
    }

    public UserGroup create(UserGroup userGroup) {
//        log.info("create {}", user);
        checkNew(userGroup);
        return service.create(userGroup);
    }

    public void delete(int id) {
//        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(UserGroup userGroup, int id) {
//        log.info("update {} with id={}", user, id);
        assureIdConsistent(userGroup, id);
        service.update(userGroup);
    }
}
