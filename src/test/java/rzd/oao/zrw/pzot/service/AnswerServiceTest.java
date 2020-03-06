package rzd.oao.zrw.pzot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class AnswerServiceTest {

    @Autowired
    protected AnswerService service;

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getWithQuestion() {
    }

    @Test
    void getByName() {
    }
}