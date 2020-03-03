package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface QuestionGroupService {
    QuestionGroup create(QuestionGroup questionGroup) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    void update(QuestionGroup questionGroup);

    QuestionGroup get(int id) throws NotFoundException;

    List<QuestionGroup> getAll();

    QuestionGroup getWithQuestions(int id) throws NotFoundException;

    QuestionGroup getByName(String name);
}
