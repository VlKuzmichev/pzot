package rzd.oao.zrw.pzot.repository;

import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.Result;

import java.util.List;

@Repository
public class ResultRepositoryImpl implements ResultRepository {

    private final CrudResultRepository resultRepository;

    public ResultRepositoryImpl(CrudResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Result save(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Result get(int id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public List<Result> getAll() {
        return resultRepository.findAll();
    }

    @Override
    public List<Result> getAllByUser(int id) {
        return resultRepository.getAllByUser(id);
    }

    @Override
    public List<Result> getByIdAndUser(int id, int userId) {
        return resultRepository.getByIdAndUser(id, userId);
    }

    @Override
    public List<Result> getResultsWithQuestionsByTestId(int testId, int userId) {
        return resultRepository.getResultsWithQuestionsByTestId(testId, userId);
    }
}
