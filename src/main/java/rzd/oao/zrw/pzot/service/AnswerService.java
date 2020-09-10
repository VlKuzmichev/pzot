package rzd.oao.zrw.pzot.service;

import rzd.oao.zrw.pzot.model.Answer;
import rzd.oao.zrw.pzot.util.NotFoundException;

import java.util.List;

public interface AnswerService {
    Answer create(Answer answer);

    void delete(int id) throws NotFoundException;

    void update(Answer answer);

    Answer get(int id) throws NotFoundException;

    List<Answer> getAll();

    List<Answer> getAllByQuestion(int id) throws NotFoundException;

//    Answer getWithQuestion(int id) throws NotFoundException;

    Answer getByName(String name);

}
