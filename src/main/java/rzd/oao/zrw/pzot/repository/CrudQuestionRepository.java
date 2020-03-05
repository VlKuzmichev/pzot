package rzd.oao.zrw.pzot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Question;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudQuestionRepository extends JpaRepository<Question, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Question q WHERE q.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Question save(Question question);

    @Override
    Optional<Question> findById(Integer id);

    @Override
    List<Question> findAll();

    @Query("SELECT q FROM Question q JOIN FETCH q.questionGroup WHERE q.id =:id")
    Question getWithQuestionGroup(@Param("id") int id);

    @Query("SELECT q FROM Question q JOIN FETCH q.tests WHERE q.id =:id")
    Question getWithTests(@Param("id") int id);

    @Query("SELECT q FROM Question q JOIN FETCH q.answers WHERE q.id =:id")
    Question getWithAnswers(@Param("id") int id);

    Question getByName(String name);

}
