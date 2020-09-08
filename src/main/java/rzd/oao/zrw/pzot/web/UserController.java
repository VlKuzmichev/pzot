package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.model.Role;
import rzd.oao.zrw.pzot.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractUserController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "editUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getId(request)));
        return "editUser";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        if (request.getParameter("id").isEmpty()) {
            User user = new User(null, request.getParameter("name"), "{noop}Zz123456",
                    request.getParameter("email").toLowerCase(), request.getParameter("fullName"), Role.ROLE_USER);
            super.create(user);
        } else if (request.getParameter("newPassword") != null) {
            User changingUser = super.get(getId(request));
            changingUser.setPassword(request.getParameter("newPassword"));
            super.update(changingUser, changingUser.getId());
            return "redirect:/";
        } else if (request.getParameter("password") != null) {
            User changingUser = super.get(getId(request));
            changingUser.setPassword(request.getParameter("password"));
            super.update(changingUser, changingUser.getId());
        } else {
            User changingUser = super.get(getId(request));
            User user = new User(null, request.getParameter("name"), " ",
                    request.getParameter("email").toLowerCase(), request.getParameter("fullName"), Role.ROLE_USER);
            user.setPassword(changingUser.getPassword());
            super.update(user, changingUser.getId());
        }
        return "redirect:/users";
    }


    @GetMapping("/changeRoles")
    public String changeRoles(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getId(request)));
        return "changeRoles";
    }

    @GetMapping("/changePassword")
    public String changePassword(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getId(request)));
        return "changePassword";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/users";
    }

    @GetMapping("/roles/add")
    public String addRole(HttpServletRequest request, ModelMap map) {
        if (request.getParameter("role") != null) {
            super.addRole(Role.valueOf(request.getParameter("role")), getId(request));
        }
        map.addAttribute("user", super.get(getId(request)));
        map.addAttribute("roles", super.getRolesForAddByUserId(getId(request)));
        return "addRoles";
    }

    @GetMapping("/role/delete")
    public String deleteRole(HttpServletRequest request, Model model) {
        String a = request.getParameter("role");
        super.removeRole(Role.valueOf(request.getParameter("role")), getId(request));
        model.addAttribute("user", super.get(getId(request)));
        return "changeRoles";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
