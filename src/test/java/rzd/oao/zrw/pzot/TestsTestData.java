package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.Status;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.of;

public class TestsTestData {

    public static final Integer TEST_ID = 100019;

    public static final Quiz TEST = new Quiz(TEST_ID, "TEST1", of(2020,Month.APRIL, 10, 10, 0), of(2020,Month.APRIL, 11, 10, 0), Status.INACTIVE);
    public static final Quiz TEST2 = new Quiz(TEST_ID + 1, "TEST1", of(2020,Month.APRIL, 11, 10, 0), of(2020,Month.APRIL, 12, 10, 0), Status.INACTIVE);
    public static final Quiz NEW_TEST = new Quiz(null, "NEW_TEST", null, null, Status.INACTIVE);



    public static List<Quiz> getTests() {
        List<Quiz> list = new ArrayList<>();
        list.add(TEST);
        list.add(TEST2);
        return list;
    }
}
