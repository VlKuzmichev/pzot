package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.UserTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserServiceTest {

    @Autowired
    protected UserService service;

    // Test creating new user
    @Test
    void create() {
        User user = getCreated();
        User created = service.create(user);
        assertThat(created).isEqualTo(user);
    }

    // Test updating user data
    @Test
    void update() {
        User updated = new User(USER);
        updated.setFullName("Updated User");
        service.update(updated);
        assertThat(service.get(USER_ID).getFullName()).isNotEqualTo(USER.getFullName());
    }

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

    // Test if not found deleting user by Id
    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(5));
    }

    // Test Get user from database by Id
    @Test
    void get() {
        User user = service.get(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER, "userGroups", "tests");
    }

    // Test Get user from database by none exist Id
    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () -> {
            User user = service.get(1);
        });
    }

    // Test Get admin from database by Email
//    @Test
//    void getByEmail() {
//        User admin = service.getByEmail(ADMIN.getEmail());
//        assertThat(admin).isEqualToIgnoringGivenFields(ADMIN, "userGroups", "tests");
//    }

    // Test Get user from database by none exist Email
//    @Test
//    void testGetNotFoundWithEmail() {
//        assertThrows(NotFoundException.class, () -> {
//            User user = service.getByEmail("asdf@asdf.com");
//        });
//    }


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

    // Test Get user with user group
    @Test
    void getWithUserGroups() {
        User user = service.getWithUserGroups(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER, "userGroups", "tests");
        User expected = USER;
        expected.setUserGroups(getUserGroups());
        // Compare first element of userGroups field
        assertThat(user.getUserGroups().get(0)).isEqualTo(expected.getUserGroups().get(0));
    }

    // Test Get examiner user from database by name
    @Test
    void getByName() {
        User exam = service.getByName(EXAMINER.getName());
        assertThat(exam).isEqualToIgnoringGivenFields(EXAMINER, "userGroups", "tests");
    }

    // Test Get not found user by name
    @Test
    void testGetNotFoundByName() {
        assertThrows(NotFoundException.class, () -> {
            User user = service.getByName("BadUser");
        });
    }

}