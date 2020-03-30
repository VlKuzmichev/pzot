package rzd.oao.zrw.pzot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rzd.oao.zrw.pzot.model.Quiz;
import rzd.oao.zrw.pzot.model.Status;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping(value = "/tests")
public class TestController extends AbstractTestController {
    // Request for create new test
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("test", new Quiz());
        return "editTest";
    }

    // Request for update test by id
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateStatus(HttpServletRequest request, Model model) {
        model.addAttribute("test", super.get(getId(request)));
        return "editTest";
    }

    // Change status of test by id (active/inactive)
    @GetMapping("/status")
    public String updateStatus(HttpServletRequest request) {
        Quiz quiz = super.get(getId(request));
        Set<Status> statuses = quiz.getStatus();
        if (statuses.contains(Status.INACTIVE)) {
            statuses.clear();
            statuses.add(Status.ACTIVE);
        } else {
            statuses.clear();
            statuses.add(Status.INACTIVE);
        }
        quiz.setStatus(statuses);
        super.update(quiz, getId(request));
        return "redirect:/tests";
    }

    // Request for update changed test or create new with edit form
    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Quiz test = new Quiz(null, request.getParameter("name"), LocalDateTime.parse(request.getParameter("startDate")),
                LocalDateTime.parse(request.getParameter("endDate")), Status.INACTIVE);
        if (request.getParameter("id").isEmpty()) {
            super.create(test);
        } else {
            super.update(test, getId(request));
        }
        return "redirect:/tests";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/tests";
    }

    @GetMapping("/users")
    public String users(HttpServletRequest request, Model model) {
        model.addAttribute("test", super.getWithUsers(getId(request)));
        return "testsUsers";
    }

    @GetMapping("/users/add")
    public String addUsers(HttpServletRequest request, ModelMap map) {
        if (request.getParameter("user") != null)
            super.addUser(getId(request), super.getUser(getUser(request)));
        map.addAttribute("test", super.get(getId(request)));
        map.addAttribute("students", super.getUsers(getId(request)));
        return "addStudents";
    }

    @GetMapping("/users/delete")
    public String deleteUserFromTest(HttpServletRequest request, Model model) {
        super.removeUser(getId(request), super.getUser(getUser(request)));
        model.addAttribute("test", super.getWithUsers(getId(request)));
        return "testsUsers";
    }


    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }

    private int getUser(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("user"));
        return Integer.parseInt(paramId);
    }

}
