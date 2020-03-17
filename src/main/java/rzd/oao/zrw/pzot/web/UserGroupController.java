package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.model.UserGroup;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/usersGroups")
public class UserGroupController extends AbstractUserGroupController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("userGroup", new UserGroup());
        return "editUsersGroup";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, Model model) {
        model.addAttribute("userGroup", super.get(getId(request)));
        return "editUsersGroup";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        UserGroup userGroup = new UserGroup(null, request.getParameter("name"));

        if (request.getParameter("id").isEmpty()) {
            super.create(userGroup);
        } else {
            super.update(userGroup, getId(request));
        }
        return "redirect:/usersGroups";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/usersGroups";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
