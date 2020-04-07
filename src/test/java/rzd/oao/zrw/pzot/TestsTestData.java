package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.Status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestsTestData {

    public static final Integer TEST_ID = 100019;

    public static final Quiz TEST = new Quiz(TEST_ID, "TEST1", null, null, Status.INACTIVE);

    public static final Quiz NEW_TEST = new Quiz(null, "NEW_TEST", null, null, Status.INACTIVE);



    public static List<Quiz> getTests() {
        List<Quiz> list = new ArrayList<>();
        list.add(TEST);
        return list;
    }
}
