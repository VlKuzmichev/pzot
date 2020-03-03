package rzd.oao.zrw.pzot.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import rzd.oao.zrw.pzot.model.QuestionGroup;

import java.util.List;

@Repository
public class QuestionGroupRepositoryImpl implements QuestionGroupRepository {
    private static final Sort SORT_NAME = new Sort(Sort.Direction.ASC, "name");

    private final CrudQuestionGroupRepository questionGroupRepository;

    public QuestionGroupRepositoryImpl(CrudQuestionGroupRepository questionGroupRepository) {
        this.questionGroupRepository = questionGroupRepository;
    }

    @Override
    public QuestionGroup save(QuestionGroup questionGroup) {
        return questionGroupRepository.save(questionGroup);
    }

    @Override
    public boolean delete(int id) {
        return questionGroupRepository.delete(id) != 0;
    }

    @Override
    public QuestionGroup get(int id) {
        return questionGroupRepository.findById(id).orElse(null);
    }

    @Override
    public List<QuestionGroup> getAll() {
        return questionGroupRepository.findAll(SORT_NAME);
    }

    @Override
    public QuestionGroup getWithQuestions(int id) {
        return questionGroupRepository.getWithQuestions(id);
    }

    @Override
    public QuestionGroup getByName(String name) {
        return questionGroupRepository.getByName(name);
    }
}
