package rzd.oao.zrw.pzot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.Quiz;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudTestRepository extends JpaRepository<Quiz, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Quiz t WHERE t.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Quiz save(Quiz test);

    @Override
    Optional<Quiz> findById(Integer id);

    @Override
    List<Quiz> findAll();

    @Query("SELECT t FROM Quiz t JOIN FETCH t.questions WHERE t.id =:id")
    Quiz getWithQuestions(@Param("id") int id);

    @Query("SELECT t FROM Quiz t JOIN FETCH t.users WHERE t.id =:id")
    Quiz getWithUsers(@Param("id") int id);

    Quiz getByName(String name);

}
