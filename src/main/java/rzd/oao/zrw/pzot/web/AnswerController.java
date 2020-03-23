package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rzd.oao.zrw.pzot.model.Answer;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/answers")
public class AnswerController extends AbstractAnswerController {
    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    public String createAnswer(@PathVariable int id, Model model) {
        Answer newanswer = new Answer();
        int qid = id;
        newanswer.setName("");
        newanswer.setQuestion(super.getQuestionById(id));
        newanswer.setTruth(false);
        model.addAttribute("answer", newanswer);
        return "editAnswer";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateAnswer(HttpServletRequest request, Model answer, Model question) {
        answer.addAttribute("answer", super.get(getId(request)));
        return "editAnswer";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        String questionId = request.getParameter("q");
        String truth = request.getParameter("truth");
        Answer answer = new Answer(null, request.getParameter("name"),
                truth == null ? false : true, super.getQuestionById(Integer.parseInt(request.getParameter("q"))));

        if (request.getParameter("id").isEmpty()) {
            super.create(answer);
        } else {
            super.update(answer, getId(request));
        }
        return "redirect:/answers/" + questionId;
    }

    @GetMapping(value = "/{id}")
    public String answerList(@PathVariable int id, Model model) {
        model.addAttribute("answerList", super.getAllByQuestion(id));
        return "answers";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        String questionId = request.getParameter("q");
        super.delete(getId(request));
        return "redirect:/answers/" + questionId;
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
