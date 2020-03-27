package rzd.oao.zrw.pzot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Quiz;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class TestRepositoryImpl implements TestRepository {
    private final CrudTestRepository testRepository;

//    @Autowired
//    private EntityManagerFactory em;

    public TestRepositoryImpl(CrudTestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Quiz save(Quiz test) {
     //   em.createEntityManager().merge(test);
        return testRepository.save(test);
    }

    @Override
    public boolean delete(int id) {
        return testRepository.delete(id) != 0;
    }

    @Override
    public Quiz get(int id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public List<Quiz> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Quiz getWithQuestions(int id) {
        return testRepository.getWithQuestions(id);
    }

    @Override
    public Quiz getWithUsers(int id) {
        return testRepository.getWithUsers(id);
    }

    @Override
    public Quiz getByName(String name) {
        return testRepository.getByName(name);
    }

//    @Override
//    public boolean deleteUserFromTest(int id) {
//        return testRepository.deleteUserFromTest(id) != 0;;
//    }
}
