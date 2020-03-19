package rzd.oao.zrw.pzot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.Answer;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudAnswerRepository extends JpaRepository<Answer, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Answer a WHERE a.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Answer save(Answer answer);

    @Override
    Optional<Answer> findById(Integer id);

    @Override
    List<Answer> findAll();

    @Query("SELECT a FROM Answer a WHERE a.question.id =:id ORDER BY a.name")
    List<Answer> getAllByQuestion(@Param("id") int id);

    @Query("SELECT a FROM Answer a JOIN FETCH a.question WHERE a.id =:id")
    Answer getWithQuestion(@Param("id") int id);

    Answer getByName(String name);
}
