package rzd.oao.zrw.pzot.repository;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "name", "email");

    private final CrudUserRepository crudUserRepository;

    public UserRepositoryImpl(CrudUserRepository crudUserRepository) {
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public User save(User user) {
        System.out.println(user);
        return crudUserRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudUserRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return crudUserRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.findAll(SORT_NAME_EMAIL);
    }

    @Override
    public User getWithUserGroups(int id) {
        return crudUserRepository.getWithUserGroups(id);
    }

    @Override
    public User getByName(String name) {
        return crudUserRepository.getByName(name);
    }
}
