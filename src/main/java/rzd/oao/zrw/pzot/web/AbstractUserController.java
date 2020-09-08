package rzd.oao.zrw.pzot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rzd.oao.zrw.pzot.model.Role;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.service.UserService;

import java.util.List;
import java.util.Set;

import static rzd.oao.zrw.pzot.util.ValidationUtil.assureIdConsistent;
import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    private final Logger log = LoggerFactory.getLogger(AbstractUserController.class);

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public void removeRole(Role role, int id) {
        log.info("removeRole {} with id={}", role, id);
        service.removeRole(role, id);
    }

    public void addRole(Role role, int id) {
        log.info("addRole {} with id={}", role, id);
        service.addRole(role, id);
    }

    public Set<Role> getRolesForAddByUserId(int id) {
        log.info("getRolesForAddByUserId {}", id);
        return service.getRolesForAdd(id);
    }
}