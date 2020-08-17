package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.QuestionGroupTestData.*;
import static rzd.oao.zrw.pzot.QuestionTestData.getQuestions;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class QuestionGroupServiceTest {

    @Autowired
    protected QuestionGroupService questionGroupService;

    // Create question group
    @Test
    void create() {
        QuestionGroup created = questionGroupService.create(NEW_QUESTION_GROUP);
        assertThat(created).isEqualTo(NEW_QUESTION_GROUP);
    }

    // Remove new group of questions from database by Id
    @Test
    void delete() {
        questionGroupService.create(NEW_QUESTION_GROUP);
        questionGroupService.delete(QUESTION_GROUP_ID + 15);
        List<QuestionGroup> actual = questionGroupService.getAll();
        List<QuestionGroup> expected = new ArrayList<>();
        expected.add(QUESTION_GROUP2);
        expected.add(QUESTION_GROUP);
        assertThat(actual).isEqualTo(expected);
    }

    // Not allowed to delete group of questions(used) from database by Id
    @Test
    void testNotAllowedToDelete() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            questionGroupService.delete(QUESTION_GROUP_ID);
        });
    }

    // Not found question to remove group by Id
    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                questionGroupService.delete(23));
    }

    // Update question group data
    @Test
    void update() {
        QuestionGroup updated = new QuestionGroup(QUESTION_GROUP);
        updated.setName("Updated QUESTION Group");
        questionGroupService.update(updated);
        assertThat(questionGroupService.get(QUESTION_GROUP_ID).getName()).isNotEqualTo(QUESTION_GROUP.getName());
    }

    // Get group of questions from database by Id
    @Test
    void get() {
        QuestionGroup questionGroup = questionGroupService.get(QUESTION_GROUP_ID);
        assertThat(questionGroup).isEqualToIgnoringGivenFields(QUESTION_GROUP, "questions");
    }

    // Get question group from database by none exist Id
    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () -> {
            QuestionGroup questionGroup = questionGroupService.get(1234);
        });
    }

    // Get all questions groups from database
    @Test
    void getAll() {
        List<QuestionGroup> actual = questionGroupService.getAll();
        assertThat(actual).isEqualTo(getQuestionsGroup());
    }

    // Get question group with questions
    @Test
    void getWithQuestions() {
        QuestionGroup actual = questionGroupService.getWithQuestions(QUESTION_GROUP_ID);
        QuestionGroup expected = QUESTION_GROUP;
        expected.setQuestions(getQuestions());
        // Compare first element of questions field
        assertThat(actual.getQuestions().get(0)).isEqualTo(expected.getQuestions().get(0));
    }

    // Get group of questions from database by name
    @Test
    void getByName() {
        QuestionGroup questionGroup = questionGroupService.getByName(QUESTION_GROUP2.getName());
        assertThat(questionGroup).isEqualToIgnoringGivenFields(QUESTION_GROUP2, "questions");
    }

    // Get not found group of users by name
    @Test
    void testGetNotFoundByName() {
        assertThrows(NotFoundException.class, () -> {
            QuestionGroup questionGroup = questionGroupService.getByName("Does not exist");
        });
    }

}