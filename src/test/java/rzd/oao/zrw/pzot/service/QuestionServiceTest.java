package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.QuestionGroupTestData.QUESTION_GROUP;
import static rzd.oao.zrw.pzot.QuestionGroupTestData.QUESTION_GROUP_ID;
import static rzd.oao.zrw.pzot.QuestionTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class QuestionServiceTest {

    @Autowired
    protected QuestionService questionService;

    // Test creating question
    @Test
    void create() {
        Question created = questionService.create(NEW_QUESTION);
        assertThat(created).isEqualTo(NEW_QUESTION);
    }

    // Test deleting question from database by Id
    @Test
    void delete() {
        questionService.delete(QUESTION_ID);
        List<Question> actual = questionService.getAll();
        List<Question> expected = new ArrayList<>();
        expected.add(QUESTION2);
        assertThat(actual).isEqualTo(expected);
    }

    // Test if not found deleting question  by Id
    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                questionService.delete(2343));
    }

    // Test updating question data
    @Test
    void update() {
        Question updated = new Question(QUESTION);
        updated.setName("Updated QUESTION");
        questionService.update(updated);
        assertThat(questionService.get(QUESTION_ID).getName()).isNotEqualTo(QUESTION.getName());
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getWithQuestionGroup() {
    }

    @Test
    void getWithAnswers() {
    }

    @Test
    void getWithTests() {
    }

    @Test
    void getByName() {
    }
}