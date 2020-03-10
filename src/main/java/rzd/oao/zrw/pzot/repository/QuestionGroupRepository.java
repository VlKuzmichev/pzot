package rzd.oao.zrw.pzot.repository;

import rzd.oao.zrw.pzot.model.QuestionGroup;

import java.util.List;

public interface QuestionGroupRepository {
    QuestionGroup save(QuestionGroup questionGroup);

    // false if not found
    boolean delete(int id);

    // null if not found
    QuestionGroup get(int id);

    List<QuestionGroup> getAll();

    // null if not found
    QuestionGroup getWithQuestions(int id);

    // null if not found
    QuestionGroup getByName(String name);

}
