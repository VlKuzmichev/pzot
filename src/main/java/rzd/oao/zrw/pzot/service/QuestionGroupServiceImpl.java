package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.repository.QuestionGroupRepository;
import rzd.oao.zrw.pzot.repository.UserRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

@Service
public class QuestionGroupServiceImpl implements QuestionGroupService {

    private final QuestionGroupRepository questionGroupRepository;

    public QuestionGroupServiceImpl(QuestionGroupRepository questionGroupRepository) {
        this.questionGroupRepository = questionGroupRepository;
    }

    @Override
    public QuestionGroup create(QuestionGroup questionGroup) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public void update(QuestionGroup questionGroup) {

    }

    @Override
    public QuestionGroup get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<QuestionGroup> getAll() {
        return null;
    }

    @Override
    public QuestionGroup getWithQuestions(int id) throws NotFoundException {
        return null;
    }

    @Override
    public QuestionGroup getByName(String name) {
        return null;
    }
}
