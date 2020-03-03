package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.model.User;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudQuestionGroupRepository extends JpaRepository<QuestionGroup, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    QuestionGroup save(QuestionGroup questionGroup);

    @Override
    Optional<QuestionGroup> findById(Integer id);

    @Override
    List<QuestionGroup> findAll(Sort sort);

    @Query("SELECT q FROM QuestionGroup q JOIN FETCH q.questions WHERE q.id =:id")
    QuestionGroup getWithQuestions(@Param("id") int id);

    QuestionGroup getByName(String name);
}
