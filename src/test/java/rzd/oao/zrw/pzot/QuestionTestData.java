package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.User;

import java.util.ArrayList;
import java.util.List;

import static rzd.oao.zrw.pzot.QuestionGroupTestData.QUESTION_GROUP;
import static rzd.oao.zrw.pzot.UserTestData.USER;

public class QuestionTestData {
    public static final Integer QUESTION_ID = 100009;

    public static final Question QUESTION = new Question(QUESTION_ID, "При какой численности работников в организации должна обязательно создаваться служба охраны труда?",
            false, QUESTION_GROUP);
    public static final Question QUESTION2 = new Question(QUESTION_ID, "Какие меры по оказанию первой помощи пострадавшему необходимо предпринять при обморожении?",
            false, QUESTION_GROUP);

    public static final Question NEW_QUESTION = new Question(QUESTION_ID, "NEW QUESTION?",
            false, QUESTION_GROUP);

    public static List<Question> getQuestions(){
        List<Question> list = new ArrayList<>();
        list.add(QUESTION2);
        list.add(QUESTION);
        return list;
    }
}
