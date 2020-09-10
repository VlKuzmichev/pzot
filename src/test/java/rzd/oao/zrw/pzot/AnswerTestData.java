package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Answer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static rzd.oao.zrw.pzot.QuestionTestData.QUESTION;
import static rzd.oao.zrw.pzot.QuestionTestData.QUESTION2;

public class AnswerTestData {
    public static final Integer ANSWER_ID = 100011;

    public static final Answer ANSWER = new Answer(ANSWER_ID, "Более 50 человек", true, QUESTION);
    public static final Answer ANSWER2 = new Answer(ANSWER_ID + 1, "Более 30 человек", false, QUESTION);
    public static final Answer ANSWER3 = new Answer(ANSWER_ID + 2, "Более 15 человек", false, QUESTION);
    public static final Answer ANSWER4 = new Answer(ANSWER_ID + 3, "Более 20 человек", false, QUESTION);

    public static final Answer ANSWER5 = new Answer(ANSWER_ID + 4, "Прекратить воздействие низких температур, " +
            "восстановить кровообращение, наложив теплоизолирующие повязки, дать обезболивающее и любое теплое питье, " +
            "доставить в лечебное учреждение", false, QUESTION2);
    public static final Answer ANSWER6 = new Answer(ANSWER_ID + 5, "Прекратить воздействие низких температур, " +
            "быстро растереть отмороженные участки, наложить сухую стерильную повязку, дать обильное питье и обезболивающее",
            false, QUESTION2);
    public static final Answer ANSWER7 = new Answer(ANSWER_ID + 6, "Прекратить воздействие низких температур, " +
            "поместив пострадавшего к источникам тепла (печи или камину), сменить одежду влажную на сухую, дать обезболивающее и" +
            " любое теплое питье", false, QUESTION2);
    public static final Answer ANSWER8 = new Answer(ANSWER_ID + 7, "Пострадавшего поместить в ванну с горячей " +
            "водой или уложить возле электронагревателя", false, QUESTION2);

    public static final Answer NEW_ANSWER = new Answer(null, "New answer", false, QUESTION);

    public static List<Answer> getAnswers() {
        List<Answer> list = Stream.of(ANSWER, ANSWER2, ANSWER3, ANSWER4, ANSWER5, ANSWER6, ANSWER7, ANSWER8)
                .collect(Collectors.toList());
        return list;
    }

    public static List<Answer> getAnswersByQuestion() {
        List<Answer> list = Stream.of(ANSWER3, ANSWER4, ANSWER2, ANSWER)
                .collect(Collectors.toList());
        return list;
    }
}
