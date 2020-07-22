package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.Result;
import rzd.oao.zrw.pzot.repository.ResultRepository;
import rzd.oao.zrw.pzot.repository.TestRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final TestRepository testRepository;

    public ResultServiceImpl(ResultRepository resultRepository, TestRepository testRepository) {
        this.resultRepository = resultRepository;
        this.testRepository = testRepository;
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

//    @Override
//    public List<Result> getAllByUser(int id) {
//        return resultRepository.getAllByUser(id);
//    }
//
//    @Override
//    public List<Integer> getTestPercent(int userId, int testId) {
//        List<Integer> percents = new ArrayList<>();
//        Integer countQuestions = testRepository.getWithQuestions(userId).getQuestions().size();
//        Integer countRightAnswers = resultRepository.getAllByUser()
//        for(Result result: resultRepository.getAllByUser(userId)) {
//
//        }
//        return
//    }
}
