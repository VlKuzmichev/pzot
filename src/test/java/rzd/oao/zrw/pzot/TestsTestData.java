package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Status;
import rzd.oao.zrw.pzot.model.Test;

import java.util.ArrayList;
import java.util.List;

public class TestsTestData {

    public static final Integer TEST_ID = 100019;

    public static final Test TEST = new Test(TEST_ID, "TEST1", null, null, Status.INACTIVE, 0, 1);

    public static final Test NEW_TEST = new Test(TEST_ID, "NEW_TEST", null, null, Status.INACTIVE, 0, 1);


    public static List<Test> getTests() {
        List<Test> list = new ArrayList<>();
        list.add(TEST);
        return list;
    }
}
