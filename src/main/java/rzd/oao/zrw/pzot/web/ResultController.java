package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.model.Question;
import rzd.oao.zrw.pzot.model.Result;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
@RequestMapping(value = "/userTests")
public class ResultController extends AbstractResultController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String doTest(@PathVariable int id, ModelMap map) {
        Question question = super.getNotAnsweredQuestion(id);
        if (question == null) return "endTest";
        map.addAttribute("question", question);
        map.addAttribute("test", super.getTest(id));
        return "doTest";
    }

    @PostMapping
    public String continueTest(HttpServletRequest request, ModelMap map) {
        int answerId = getAnswerId(request);
        int testId = getTestId(request);
        Result result = new Result(LocalDateTime.now(), super.getUser(), super.getTest(testId),
                super.getNotAnsweredQuestion(testId), super.getAnswer(answerId));
        if (!request.getParameter("answer").isEmpty()) super.create(result);
        Question question = super.getNotAnsweredQuestion(testId);
        if (question == null) return "endTest";
        map.addAttribute("question", question);
        map.addAttribute("test", super.getTest(testId));
        return "doTest";
    }

    private int getAnswerId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("answer"));
        return Integer.parseInt(paramId);
    }

    private int getTestId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("testId"));
        return Integer.parseInt(paramId);
    }

    private int getQuestion(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("question"));
        return Integer.parseInt(paramId);
    }

}
