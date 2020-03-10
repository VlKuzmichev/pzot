package rzd.oao.zrw.pzot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.Test;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudTestRepository extends JpaRepository<Test, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Test t WHERE t.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Test save(Test test);

    @Override
    Optional<Test> findById(Integer id);

    @Override
    List<Test> findAll();

    @Query("SELECT t FROM Test t JOIN FETCH t.questions WHERE t.id =:id")
    Test getWithQuestions(@Param("id") int id);

    @Query("SELECT t FROM Test t JOIN FETCH t.users WHERE t.id =:id")
    Test getWithUsers(@Param("id") int id);

    Test getByName(String name);


}
