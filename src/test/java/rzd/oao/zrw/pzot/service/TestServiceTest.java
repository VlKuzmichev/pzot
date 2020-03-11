package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.QuestionTestData.getQuestions;
import static rzd.oao.zrw.pzot.TestsTestData.*;
import static rzd.oao.zrw.pzot.UserGroupTestData.getUsers;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class TestServiceTest {

    @Autowired
    protected TestService testService;

    // Test creating test
    @Test
    void create() {
        Quiz created = testService.create(NEW_TEST);
        assertThat(created).isEqualTo(NEW_TEST);
    }

    // Test deleting test from database by Id
    @Test
    void delete() {
        testService.delete(TEST_ID);
        List<Quiz> actual = testService.getAll();
        // Using Stream API to collect answers to list for assert
        List<Quiz> expected = new ArrayList<>();
        assertThat(actual).isEqualTo(expected);
    }

    // Test if not found deleting test  by Id
    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                testService.delete(23643));
    }

    // Test updating test data
    @Test
    void update() {
        Quiz updated = new Quiz(TEST);
        updated.setName("Updated TEST");
        testService.update(updated);
        assertThat(testService.get(TEST_ID).getName()).isNotEqualTo(TEST.getName());
    }

    // Test Get test from database by Id
    @Test
    void get() {
        Quiz test = testService.get(TEST_ID);
        assertThat(test).isEqualTo(TEST);
    }

    // Test Get test from database by none exist Id
    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () -> {
            Quiz test = testService.get(43);
        });
    }

    // Test Get all tests from database
    @Test
    void getAll() {
        List<Quiz> actual = testService.getAll();
        assertThat(actual).isEqualTo(getTests());
    }

    // Test Get test with questions
    @Test
    void getWithQuestions() {
        Quiz actual = testService.getWithQuestions(TEST_ID);
        Quiz expected = TEST;
        expected.setQuestions(getQuestions());
        // Compare first element of questions field
        assertThat(actual.getQuestions().get(0)).isEqualTo(expected.getQuestions().get(0));
    }

    // Test Get test with users
    @Test
    void getWithUsers() {
        Quiz actual = testService.getWithUsers(TEST_ID);
        Quiz expected = TEST;
        expected.setUsers(getUsers());
        // Compare first element of users field
        assertThat(actual.getUsers().get(0)).isEqualTo(expected.getUsers().get(0));
    }

    // Test Get test from database by name
    @Test
    void getByName() {
        Quiz test = testService.getByName(TEST.getName());
        assertThat(test).isEqualTo(TEST);
    }
}