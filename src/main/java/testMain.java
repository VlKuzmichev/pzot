import org.springframework.context.support.GenericXmlApplicationContext;

public class testMain {
    public static void main(String[] args) {
        GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext();
        appCtx.load("spring/spring-app.xml");
        appCtx.refresh();

//        QuestionGroup questionGroup = new QuestionGroup(100000, "Личные вопросы", null);
//        Question que1 = new Question(100001, "Как дела?", 1, questionGroup, null);
//        List<Answer> answers = new ArrayList();
//        answers.add(new Answer(100002, "Нормально", true, que1));
//        answers.add(new Answer(100003, "Так себе", false, que1));
//        answers.add(new Answer(100004, "Вроде хорошо", true, que1));
//        que1.setAnswers(answers);
//        List<Question> questions = new ArrayList();
//        questions.add(que1);
//        questionGroup.setQuestions(questions);
//        System.out.println(que1);
    }
}
