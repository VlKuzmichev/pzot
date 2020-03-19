package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static rzd.oao.zrw.pzot.AnswerTestData.*;
import static rzd.oao.zrw.pzot.QuestionTestData.QUESTION2;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class AnswerServiceTest {

    @Autowired
    protected AnswerService answerService;

    // Test creating answer
    @Test
    void create() {
        Answer created = answerService.create(NEW_ANSWER);
        assertThat(created).isEqualTo(NEW_ANSWER);
    }

    // Test deleting answer from database by Id
    @Test
    void delete() {
        answerService.delete(ANSWER_ID);
        List<Answer> actual = answerService.getAll();
        // Using Stream API to collect answers to list for assert
        List<Answer> expected = Stream.of(ANSWER2, ANSWER3, ANSWER4, ANSWER5, ANSWER6, ANSWER7, ANSWER8)
                .collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

    // Test if not found deleting answer  by Id
    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () ->
                answerService.delete(23643));
    }

    // Test updating answer data
    @Test
    void update() {
        Answer updated = new Answer(ANSWER);
        updated.setName("Updated ANSWER");
        answerService.update(updated);
        assertThat(answerService.get(ANSWER_ID).getName()).isNotEqualTo(ANSWER.getName());
    }

    // Test Get answer from database by Id
    @Test
    void get() {
        Answer answer = answerService.get(ANSWER_ID);
        assertThat(answer).isEqualTo(ANSWER);
    }

    // Test Get answer from database by none exist Id
    @Test
    void testGetNotFound() {
        assertThrows(NotFoundException.class, () -> {
            Answer answer = answerService.get(43);
        });
    }

    // Test Get all answers from database
    @Test
    void getAll() {
        List<Answer> actual = answerService.getAll();
        assertThat(actual).isEqualTo(getAnswers());
    }

    // Test Get all answers from database
    @Test
    void getAllByQuestion() {
        List<Answer> actual = answerService.getAllByQuestion(100009);
        assertThat(actual).isEqualTo(getAnswersByQuestion());
    }

    // Test Get question from database by name
    @Test
    void getByName() {
        Answer answer = answerService.getByName(ANSWER.getName());
        assertThat(answer).isEqualTo(ANSWER);
    }
}