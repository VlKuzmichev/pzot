package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.AnswerTestData.getAnswers;
import static rzd.oao.zrw.pzot.QuestionTestData.*;
import static rzd.oao.zrw.pzot.TestsTestData.getTests;

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

    // Test Get question from database by Id
    @Test
    void get() {
        Question question = questionService.get(QUESTION_ID);
        assertThat(question).isEqualToIgnoringGivenFields(QUESTION, "answers", "tests");
    }

    // Test Get question from database by none exist Id
    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () -> {
            Question question = questionService.get(12354);
        });
    }

    // Test Get all questions groups from database
    @Test
    void getAll() {
        List<Question> actual = questionService.getAll();
        assertThat(actual).isEqualTo(getQuestions());
    }

//    @Test
//    void getWithQuestionGroup() {
//    }

    // Test Get question with answers
    @Test
    void getWithAnswers() {
        Question actual = questionService.getWithAnswers(QUESTION_ID);
        assertThat(actual).isEqualToIgnoringGivenFields(QUESTION, "tests", "answers");
        Question expected = QUESTION;
        expected.setAnswers(getAnswers());
        // Compare first element of answers field
        assertThat(actual.getAnswers().get(0)).isEqualTo(expected.getAnswers().get(0));
    }

    // Test Get question with tests
    @Test
    void getWithTests() {
        Question actual = questionService.getWithTests(QUESTION_ID);
        assertThat(actual).isEqualToIgnoringGivenFields(QUESTION, "tests", "answers");
        Question expected = QUESTION;
        expected.setTests(getTests());
        // Compare first element of answers field
        assertThat(actual.getTests().get(0)).isEqualTo(expected.getTests().get(0));
    }

    // Test Get question from database by name
    @Test
    void getByName() {
        Question question = questionService.getByName("Какие меры по оказанию первой помощи пострадавшему необходимо " +
                "предпринять при обморожении?");
        assertThat(question).isEqualToIgnoringGivenFields(QUESTION2, "answers", "tests");
    }

    // Test Get not found question by name
    @Test
    void testGetNotFoundByName() {
        assertThrows(NotFoundException.class, () -> {
            Question question = questionService.getByName("Does not exist");
        });
    }
}