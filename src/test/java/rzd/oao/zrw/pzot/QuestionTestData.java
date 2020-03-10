package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Question;

import java.util.ArrayList;
import java.util.List;

import static rzd.oao.zrw.pzot.QuestionGroupTestData.QUESTION_GROUP;

public class QuestionTestData {
    public static final Integer QUESTION_ID = 100009;

    public static final Question QUESTION = new Question(QUESTION_ID, "При какой численности работников в организации должна обязательно создаваться служба охраны труда?",
            false, QUESTION_GROUP);
    public static final Question QUESTION2 = new Question(QUESTION_ID + 1, "Какие меры по оказанию первой помощи пострадавшему необходимо предпринять при обморожении?",
            false, QUESTION_GROUP);

    public static final Question NEW_QUESTION = new Question(QUESTION_ID + 11, "NEW QUESTION?",
            false, QUESTION_GROUP);

    public static List<Question> getQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(QUESTION);
        list.add(QUESTION2);
        return list;
    }
}
