package rzd.oao.zrw.pzot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.Role;
import rzd.oao.zrw.pzot.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static rzd.oao.zrw.pzot.UserTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserRepositoryImplTest {

    @Autowired
    protected UserRepository repository;

    @Test
    void save() {
    }

//    @Test
//    void testUpdate() throws Exception {
//        User updated = new User(USER);
//        updated.setFullName("Updated User Userovich");
//        repository.update(updated, USER_ID);
//        assertMatch(service.get(USER_ID), updated);
//    }

    // Test deleting user from database by Id
    @Test
    void delete() {
        repository.delete(EXAMINER_ID);
        List<User> actual = repository.getAll();
        List<User> expected = new ArrayList<>();
        expected.add(ADMIN);
        expected.add(USER);
        assertThat(actual).isEqualTo(expected);
    }

    // Test Get user from database by Id
    @Test
    void get() {
        User user = repository.get(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER, "userGroups");
    }

    // Test Get admin from database by Email
    @Test
    void getByEmail() {
        User admin = repository.getByEmail("admin@yandex.ru");
        assertThat(admin).isEqualToIgnoringGivenFields(ADMIN, "userGroups");
    }

    // Test Get all users from database
    @Test
    void getAll() {
        List<User> actual = repository.getAll();
        List<User> expected = new ArrayList<>();
        expected.add(ADMIN);
        expected.add(EXAMINER);
        expected.add(USER);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWithUserGroups() {
        User user = repository.getWithUserGroups(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER, "userGroups");
        User expected = USER;
        expected.setUserGroups(getUserGroups());
        // Compare first element of userGroups field
        assertThat(user.getUserGroups().get(0)).isEqualTo(expected.getUserGroups().get(0));
    }

    // Test Get examiner user from database by name
    @Test
    void getByName() {
        User exam = repository.getByName("Exam");
        assertThat(exam).isEqualToIgnoringGivenFields(EXAMINER, "userGroups");
    }
}