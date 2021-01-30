package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.Result;

import java.util.List;

public interface ResultRepository {
    Result save(Result result);

    // null if not found
    Result get(int id);

    List<Result> getAll();

    List<Result> getAllByUser(int id);

    List<Result> getAllByUserWithTests(int id);

    List<Result> getResultsWithQuestionsByTestId(int testId, int userId);

    List<Result> getAllByUserAndTest(int userId, int testId);
}
