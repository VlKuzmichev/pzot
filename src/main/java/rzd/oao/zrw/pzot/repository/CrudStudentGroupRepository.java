package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rzd.oao.zrw.pzot.model.Group;

import java.util.List;
import java.util.Optional;

public interface CrudStudentGroupRepository  extends JpaRepository<Group, Integer> {
    @Modifying
    @Query("DELETE FROM Group u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    Group save(Group group);

    @Override
    Optional<Group> findById(Integer id);

    @Override
    List<Group> findAll(Sort sort);

    Group getByName(String name);

}
