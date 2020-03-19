package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.model.Question;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController extends AbstractQuestionController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(ModelMap map) {
        map.addAttribute("groups", super.getAllQuestionsGroups());
        map.addAttribute("question", new Question());
        return "editQuestion";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, ModelMap map) {
        map.addAttribute("groups", super.getAllQuestionsGroups());
        map.addAttribute("question", super.get(getId(request)));
        return "editQuestion";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        String str = request.getParameter("num");
        int questionGroupId = Integer.parseInt(request.getParameter("num"));
        Question question = new Question(null, request.getParameter("name"), false,
                super.getQuestion(questionGroupId));

        if (request.getParameter("id").isEmpty()) {
            super.create(question);
        } else {
            super.update(question, getId(request));
        }
        return "redirect:/questions";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/questions";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
