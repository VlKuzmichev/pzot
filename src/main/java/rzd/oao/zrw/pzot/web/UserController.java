package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        User user = new User(null, request.getParameter("name"), "{noop}Zz123456",
                request.getParameter("email").toLowerCase(), request.getParameter("fullName"), Role.ROLE_USER);

        if (request.getParameter("id").isEmpty()) {
            super.create(user);
        } else {
            User changingUser = super.get(getId(request));
            user.setPassword(changingUser.getPassword());
            super.update(user, changingUser.getId());
        }
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/users";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

}
