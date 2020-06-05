package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.Result;

import java.util.List;

public interface ResultRepository {
    Result save(Result result);

    // null if not found
    Result get(int id);

    List<Result> getAll();

    // null if not found
    List<Result> getAllByUser(int id);

}
