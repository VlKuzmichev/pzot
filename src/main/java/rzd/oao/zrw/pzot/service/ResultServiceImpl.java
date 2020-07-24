package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.Result;
import rzd.oao.zrw.pzot.repository.ResultRepository;
import rzd.oao.zrw.pzot.repository.TestRepository;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final TestRepository testRepository;
    private final UserRepository userRepository;

    public ResultServiceImpl(ResultRepository resultRepository, TestRepository testRepository, UserRepository userRepository) {
        this.resultRepository = resultRepository;
        this.testRepository = testRepository;
        this.userRepository = userRepository;
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
    public List<Integer> getTestsPercents(int userId) {
        List<Integer> tests = new ArrayList<>();
        for (Quiz test : userRepository.getWithTests(userId).getTests()) {
            tests.add(test.getId());
        }
        List<Integer> answers = new ArrayList<>();
        for (Integer testId : tests) {
            answers.add(resultRepository.getByIdAndUser(testId, userId).size());
        }
        List<Integer> questions = new ArrayList<>();
        for (Quiz test : userRepository.getWithTests(userId).getTests()) {
            questions.add(test.getQuestions().size());
        }
        List<Integer> percents = new ArrayList<>();
        for (int i = 0; i < tests.size(); i++) {
            percents.add(100 / questions.get(i) * answers.get(i));
        }
        return percents;
    }
}
