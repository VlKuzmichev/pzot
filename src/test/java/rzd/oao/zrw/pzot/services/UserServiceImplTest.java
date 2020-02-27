package rzd.oao.zrw.pzot.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static rzd.oao.zrw.pzot.UserTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserServiceImplTest {

    @Autowired
    protected UserService service;

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
        service.delete(EXAMINER_ID);
        List<User> actual = service.getAll();
        List<User> expected = new ArrayList<>();
        expected.add(ADMIN);
        expected.add(USER);
        assertThat(actual).isEqualTo(expected);
    }

    // Test Get user from database by Id
    @Test
    void get() {
        User user = service.get(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER, "userGroups");
    }

    // Test Get admin from database by Email
    @Test
    void getByEmail() {
        User admin = service.getByEmail("admin@yandex.ru");
        assertThat(admin).isEqualToIgnoringGivenFields(ADMIN, "userGroups");
    }

    // Test Get all users from database
    @Test
    void getAll() {
        List<User> actual = service.getAll();
        List<User> expected = new ArrayList<>();
        expected.add(ADMIN);
        expected.add(EXAMINER);
        expected.add(USER);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWithUserGroups() {
        User user = service.getWithUserGroups(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER, "userGroups");
        User expected = USER;
        expected.setUserGroups(getUserGroups());
        // Compare first element of userGroups field
        assertThat(user.getUserGroups().get(0)).isEqualTo(expected.getUserGroups().get(0));
    }

    // Test Get examiner user from database by name
    @Test
    void getByName() {
        User exam = service.getByName("Exam");
        assertThat(exam).isEqualToIgnoringGivenFields(EXAMINER, "userGroups");
    }
}