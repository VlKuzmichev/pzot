package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudUserGroupRepository extends JpaRepository<UserGroup, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM UserGroup ug WHERE ug.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    UserGroup save(UserGroup userGroup);

    @Override
    Optional<UserGroup> findById(Integer id);

    @Override
    List<UserGroup> findAll(Sort sort);

    @Query("SELECT ug FROM UserGroup ug JOIN FETCH ug.users WHERE ug.id =:id")
    UserGroup getWithUsers(@Param("id") int id);

    UserGroup getByName(String name);

}
