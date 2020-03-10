package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.QuestionGroup;

import java.util.ArrayList;
import java.util.List;

public class QuestionGroupTestData {
    public static final Integer QUESTION_GROUP_ID = 100007;

    public static final QuestionGroup QUESTION_GROUP = new QuestionGroup(QUESTION_GROUP_ID, "VOPROSY PO OT");

    public static final QuestionGroup QUESTION_GROUP2 = new QuestionGroup(QUESTION_GROUP_ID + 1, "VOPROSY PO ELEKTROBEZOPASNOSTY");

    public static final QuestionGroup NEW_QUESTION_GROUP = new QuestionGroup(QUESTION_GROUP_ID + 13, "NEW GROUP");

    public static List<QuestionGroup> getQuestionsGroup() {
        List<QuestionGroup> list = new ArrayList<>();
        list.add(QUESTION_GROUP2);
        list.add(QUESTION_GROUP);
        return list;
    }

}
