package rzd.oao.zrw.pzot.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.repository.QuestionGroupRepository;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

import static rzd.oao.zrw.pzot.util.ValidationUtil.checkNotFoundWithId;

@Service
public class QuestionGroupServiceImpl implements QuestionGroupService {
    private final QuestionGroupRepository questionGroupRepository;

    public QuestionGroupServiceImpl(QuestionGroupRepository questionGroupRepository) {
        this.questionGroupRepository = questionGroupRepository;
    }

    @Override
    public QuestionGroup create(QuestionGroup questionGroup) throws NotFoundException {
        Assert.notNull(questionGroup, "user must not be null");
        return questionGroupRepository.save(questionGroup);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!questionGroupRepository.delete(id)) throw new NotFoundException("Not found with id=" + id);
    }

    @Override
    public void update(QuestionGroup questionGroup) {
        questionGroupRepository.save(questionGroup);
    }

    @Override
    public QuestionGroup get(int id) throws NotFoundException {
        return checkNotFoundWithId(questionGroupRepository.get(id), id);
    }

    @Override
    public List<QuestionGroup> getAll() {
        return questionGroupRepository.getAll();
    }

    @Override
    public QuestionGroup getWithQuestions(int id) throws NotFoundException {
        return questionGroupRepository.getWithQuestions(id);
    }

    @Override
    public QuestionGroup getByName(String name) {
        QuestionGroup questionGroup = questionGroupRepository.getByName(name);
        if (questionGroup == null) throw new NotFoundException("Name=" + name);
        return questionGroupRepository.getByName(name);
    }
}
