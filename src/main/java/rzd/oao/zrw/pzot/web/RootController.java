package rzd.oao.zrw.pzot.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Objects;

@Controller
public class RootController extends AbstractUserController {

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

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "users";
    }

    @PreAuthorize("hasRole('ROLE_EXAMINER')")
    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String testList(Model model) {
        model.addAttribute("testList", testService.getAll());
        return "tests";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/usersGroups", method = RequestMethod.GET)
    public String userGroupList(Model model) {
        model.addAttribute("userGroupList", userGroupService.getAll());
        return "usersGroups";
    }

    @PreAuthorize("hasRole('ROLE_EXAMINER')")
    @RequestMapping(value = "/questionsGroups", method = RequestMethod.GET)
    public String questionGroupList(Model model) {
        model.addAttribute("questionGroupList", questionGroupService.getAll());
        return "questionsGroups";
    }

    @PreAuthorize("hasRole('ROLE_EXAMINER')")
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String questionList(Model model) {
        model.addAttribute("questionList", questionService.getAll());
        return "questions";
    }

    @RequestMapping(value = "/userTests", method = RequestMethod.GET)
    public String userTestsList(ModelMap map) {
        map.addAttribute("userTestList", userService.getUserTests());
        map.addAttribute("percentList", resultService.getTestsPercents());
        return "userTests";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String changePassword(Model model, Principal user) {
        model.addAttribute("user", userService.getByName(user.getName()));
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(HttpServletRequest request, @Valid User user, BindingResult result, SessionStatus status, @AuthenticationPrincipal User authUser) {
        if (result.hasErrors()) {
            return "profile";
        }
        if (request.getParameter("newPassword") != null) {
            User changingUser = super.get(user.getId());
            changingUser.setPassword(request.getParameter("newPassword"));
            super.update(changingUser, changingUser.getId());
            authUser.setPassword(request.getParameter("newPassword"));
            status.setComplete();
            return "redirect:/";
        }
        return "profile";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}


