package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.List;
import java.util.Optional;

public interface CrudUserGroupRepository extends JpaRepository<UserGroup, Integer> {
    @Modifying
    @Query("DELETE FROM UserGroup u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    UserGroup save(UserGroup group);

    @Override
    Optional<UserGroup> findById(Integer id);

    @Override
    List<UserGroup> findAll(Sort sort);

    UserGroup getByName(String name);

}
