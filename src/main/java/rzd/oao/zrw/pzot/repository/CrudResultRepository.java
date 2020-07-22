package rzd.oao.zrw.pzot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Result;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudResultRepository extends JpaRepository<Result, Integer> {

    @Override
    @Transactional
    Result save(Result result);

    @Override
    Optional<Result> findById(Integer id);

    @Override
    List<Result> findAll();

//    @Query("SELECT r FROM Result r JOIN FETCH r.users WHERE r.id =:id")
//    List<Result> getAllByUser(int id);
//
//    @Query("SELECT r FROM Result r JOIN FETCH r.users WHERE r.id =:id AND r.")
//    Result getByIdAndUser(@Param("id") int id, @Param("userId") int userId);

}
