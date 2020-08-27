package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Result;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;
import java.util.Map;

public interface ResultService {
    Result create(Result result);

    Result get(int id) throws NotFoundException;

    List<Result> getAll();

    List<Result> getAllByUser(int id);

    List<Integer> getTestsPercents();

    Question getNotAnsweredQuestion(int userId, int testId);

    int getUserResult(int userId, int testId);

    Map<User, Integer> getAllResultsByTest(int testId);

    Map<Integer, Integer> getAllUsersTestStatuses(int testId);

}
