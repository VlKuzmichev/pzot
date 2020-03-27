package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.UserGroupTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class UserGroupServiceTest {

    @Autowired
    protected UserGroupService service;

    // Test creating new user group
    @Test
    void create() {
        UserGroup created = service.create(NEW_USER_GROUP);
        assertThat(created).isEqualTo(NEW_USER_GROUP);
    }

    // Test deleting group of users from database by Id
    @Test
    void delete() {
        service.delete(USER_GROUP_ID);
        List<UserGroup> actual = service.getAll();
        List<UserGroup> expected = new ArrayList<>();
        expected.add(USER_GROUP3);
        expected.add(USER_GROUP4);
        expected.add(USER_GROUP2);
        assertThat(actual).isEqualTo(expected);
    }

    // Test if not found deleting user by Id
    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.delete(12));
    }

    // Test updating user group data
    @Test
    void update() {
        UserGroup updated = new UserGroup(USER_GROUP);
        updated.setName("Updated UserGroup");
        service.update(updated);
        assertThat(service.get(USER_GROUP_ID).getName()).isNotEqualTo(USER_GROUP.getName());
    }

    // Test Get group of users from database by Id
    @Test
    void get() {
        UserGroup userGroup = service.get(USER_GROUP_ID);
        assertThat(userGroup).isEqualToIgnoringGivenFields(USER_GROUP, "users");
    }

    // Test Get user from database by none exist Id
    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () -> {
            UserGroup userGroup = service.get(123);
        });
    }

    // Test Get all user groups from database
    @Test
    void getAll() {
        List<UserGroup> actual = service.getAll();
        List<UserGroup> expected = new ArrayList<>();
        expected.add(USER_GROUP);
        expected.add(USER_GROUP3);
        expected.add(USER_GROUP4);
        expected.add(USER_GROUP2);
        assertThat(actual).isEqualTo(expected);
    }

    // Test Get group with users
    @Test
    void getWithUsers() {
        UserGroup userGroup = service.getWithUsers(USER_GROUP_ID);
        assertThat(userGroup).isEqualToIgnoringGivenFields(USER_GROUP, "users");
        UserGroup expected = USER_GROUP;
   //     expected.setUsers(getUsers());
        // Compare first element of users field
        assertThat(userGroup.getUsers().get(0)).isEqualTo(expected.getUsers().get(0));
    }

    // Test Get group of users from database by name
    @Test
    void getByName() {
        UserGroup userGroup = service.getByName(USER_GROUP2.getName());
        assertThat(userGroup).isEqualToIgnoringGivenFields(USER_GROUP2, "users");
    }

    // Test Get not found user by name
    @Test
    void testGetNotFoundByName() {
        assertThrows(NotFoundException.class, () -> {
            UserGroup userGroup = service.getByName("Does not exist");
        });
    }

}