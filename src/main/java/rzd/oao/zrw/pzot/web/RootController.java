package rzd.oao.zrw.pzot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.service.QuestionGroupService;
import rzd.oao.zrw.pzot.service.UserGroupService;
import rzd.oao.zrw.pzot.service.UserService;

@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "users";
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

}


