package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.service.*;

@Controller
public class RootController {

    private final UserService userService;

    private final UserGroupService userGroupService;

    private final QuestionGroupService questionGroupService;

    private final QuestionService questionService;

    private final TestService testService;

    private final ResultService resultService;

    public RootController(UserService userService, UserGroupService userGroupService, QuestionGroupService questionGroupService, QuestionService questionService, TestService testService, ResultService resultService) {
        this.userService = userService;
        this.userGroupService = userGroupService;
        this.questionGroupService = questionGroupService;
        this.questionService = questionService;
        this.testService = testService;
        this.resultService = resultService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String testList(Model model) {
        model.addAttribute("testList", testService.getAll());
        return "tests";
    }

    @RequestMapping(value = "/usersGroups", method = RequestMethod.GET)
    public String userGroupList(Model model) {
        model.addAttribute("userGroupList", userGroupService.getAll());
        return "usersGroups";
    }

    @RequestMapping(value = "/questionsGroups", method = RequestMethod.GET)
    public String questionGroupList(Model model) {
        model.addAttribute("questionGroupList", questionGroupService.getAll());
        return "questionsGroups";
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questionList(Model model) {
        model.addAttribute("questionList", questionService.getAll());
        return "questions";
    }

    @RequestMapping(value = "/userTests", method = RequestMethod.GET)
    public String userTestsList(ModelMap map) {
        map.addAttribute("userTestList", userService.getWithTests(100004).getTests());
        map.addAttribute("percentList", resultService.getTestsPercents(100004));
        return "userTests";
    }

}


