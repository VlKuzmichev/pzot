package rzd.oao.zrw.pzot.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.repository.UserGroupRepository;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@Service("userService")
public class UserServiceImpl implements UserService {//, UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final UserRepository repository;
//    private final UserGroupRepository groupRepository;
//    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository,/*, PasswordEncoder passwordEncoder*/UserGroupRepository groupRepository) {
        this.repository = repository;
//        this.passwordEncoder = passwordEncoder;
//        this.groupRepository = groupRepository;
    }

    @Transactional
    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Transactional
    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) throw new NotFoundException("Not found with id=" + id);
    }

    @Transactional
    @Override
    public void update(User user) {
        repository.save(user /*prepareToSave(user, passwordEncoder)*/);
//        UserGroup group = groupRepository.get(user.getGroup().getId());
//        group.addUser(user);
//        groupRepository.save(group);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);//checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<User> getAll() {
        log.info("get users");
        return repository.getAll();
    }

//    @Override
//    public User getByName(String name) {
//        User user = repository.getByName(name);
//        if (user == null) throw new NotFoundException("Name=" + name);
//        return repository.getByName(name);
//    }

//    @Override
//    public AuthorizedUser loadUserByUsername(String name) throws UsernameNotFoundException {
//        User user = repository.getByName(name);
//        if (user == null) {
//            throw new UsernameNotFoundException("User " + name + " is not found");
//        }
//
//        return new AuthorizedUser(user);
//    }

//    @Override
//    public void removeRole(Role role, int userId) {
//        User user = repository.get(userId);
//        user.getRoles().remove(role);
//        repository.save(user);
//    }

//    @Override
//    public void addRole(Role role, int userId) {
//        User user = repository.get(userId);
//        user.getRoles().add(role);
//        repository.save(user);
//    }
//
//    @Override
//    public Set<Role> getRolesForAdd(int userId) {
//        Set<Role> userRoles = repository.get(userId).getRoles();
//        Set<Role> allRoles = new HashSet<>();
//        allRoles.addAll(Arrays.asList(Role.class.getEnumConstants()));
//        allRoles.removeAll(userRoles);
//        return allRoles;
//    }
}
