package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.Result;
import rzd.oao.zrw.pzot.repository.QuestionRepository;
import rzd.oao.zrw.pzot.repository.ResultRepository;
import rzd.oao.zrw.pzot.repository.TestRepository;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;
import rzd.oao.zrw.pzot.web.SecurityUtil;

import java.util.ArrayList;
import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final TestRepository testRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public ResultServiceImpl(ResultRepository resultRepository, TestRepository testRepository, UserRepository userRepository,
                             QuestionRepository questionRepository) {
        this.resultRepository = resultRepository;
        this.testRepository = testRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Result create(Result result) {
        Assert.notNull(result, "result must not be null");
        return resultRepository.save(result);
    }

    @Override
    public Result get(int id) throws NotFoundException {
        return checkNotFoundWithId(resultRepository.get(id), id);
    }

    @Override
    public List<Result> getAll() {
        return resultRepository.getAll();
    }

    @Override
    public List<Result> getAllByUser(int id) {
        return resultRepository.getAllByUser(id);
    }

    @Override
    public List<Integer> getTestsPercents() {
        int userId = SecurityUtil.authUserId();
        List<Integer> tests = new ArrayList<>();
        for (Quiz test : userRepository.getWithTests(userId).getTests()) {
            tests.add(test.getId());
        }
        List<Integer> answers = new ArrayList<>();
        for (Integer testId : tests) {
            answers.add(resultRepository.getByIdAndUser(testId, userId).size());
        }
        List<Integer> questionsCounts = new ArrayList<>();
        for (Quiz test : userRepository.getWithTests(userId).getTests()) {
            questionsCounts.add(test.getQuestions().size());
        }
        int questionCount;
        List<Integer> percents = new ArrayList<>();
        for (int i = 0; i < tests.size(); i++) {
            questionCount = questionsCounts.get(i);
            if (questionCount != 0) {
                percents.add(100 / questionsCounts.get(i) * answers.get(i));
            }else {
                percents.add(0);
            }
        }
        return percents;
    }

    @Override
    public Question getNotAnsweredQuestion(int userId, int testId) {
        List<Question> questions = questionRepository.getAllByTestId(testId);
        Boolean found = false;

        List<Question> answeredQuestions = new ArrayList<>();
        List<Result> results = resultRepository.getResultsWithQuestionsByTestId(testId, userId);
        for (Result result : results) {
            answeredQuestions.add(result.getQuestion());
        }
        for (Question question : questions) {
            for (Question answeredQuestion : answeredQuestions) {
                if (question.equals(answeredQuestion)) found = true;
            }
            if (!found) {
                return question;
            } else {
                found = false;
            }
        }
        return null;
    }
}
