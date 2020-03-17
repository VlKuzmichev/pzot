package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.model.QuestionGroup;
import rzd.oao.zrw.pzot.model.UserGroup;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/questionsGroups")
public class QuestionGroupController extends AbstractQuestionGroupController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("questionGroup", new QuestionGroup());
        return "editQuestionsGroup";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, Model model) {
        model.addAttribute("questionGroup", super.get(getId(request)));
        return "editQuestionsGroup";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        QuestionGroup questionGroup = new QuestionGroup(null, request.getParameter("name"));

        if (request.getParameter("id").isEmpty()) {
            super.create(questionGroup);
        } else {
            super.update(questionGroup, getId(request));
        }
        return "redirect:/questionsGroups";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/questionsGroups";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
