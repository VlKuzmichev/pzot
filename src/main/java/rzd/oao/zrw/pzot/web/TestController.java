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
    public String updateTest(HttpServletRequest request, Model model) {
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
        String startDate = addTChar(request.getParameter("startDate"));
        String endDate = addTChar(request.getParameter("endDate"));
        Quiz test = new Quiz(null, request.getParameter("name"), (LocalDateTime.parse(startDate)),
                LocalDateTime.parse(endDate), Status.INACTIVE);
        if (request.getParameter("id").isEmpty()) {
            super.create(test);
        } else {
            Quiz updated = super.get(getId(request));
            updated.setName(test.getName());
            updated.setStartDate(test.getStartDate());
            updated.setEndDate(test.getEndDate());
            super.update(updated, getId(request));
        }
        return "redirect:/tests";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getId(request));
        return "redirect:/tests";
    }

    @GetMapping("/users")
    public String users(HttpServletRequest request, ModelMap map) {
        map.addAttribute("testId", super.get(getId(request)).getId());
        map.addAttribute("testWithUsers", super.getWithUsers(getId(request)));
        return "testsUsers";
    }

    @GetMapping("/questions")
    public String questions(HttpServletRequest request, ModelMap map) {
        map.addAttribute("testId", super.get(getId(request)).getId());
        map.addAttribute("testWithQuestions", super.getWithQuestions(getId(request)));
        return "testsQuestions";
    }

    @GetMapping("/results")
    public String results(HttpServletRequest request, ModelMap map) {
        map.addAttribute("resultList", super.getAllResults(getId(request)));
        map.addAttribute("statusList", super.getAllUsersTestStatuses(getId(request)));
        return "allResults";
    }

    @GetMapping("/questions/add")
    public String addQuestions(HttpServletRequest request, ModelMap map) {
        if (request.getParameter("question") != null) {
            super.addQuestion(getId(request), super.getQuestion(getQuestion(request)));
        }
        map.addAttribute("testQuestions", super.getWithoutTestQuestions(getId(request)));
        map.addAttribute("test", super.get(getId(request)));
        return "addQuestions";
    }

    @GetMapping("/questions/delete")
    public String deleteQuestionFromTest(HttpServletRequest request, ModelMap map) {
        super.removeQuestion(getId(request), super.getQuestion(getQuestion(request)));
        map.addAttribute("testId", super.get(getId(request)).getId());
        map.addAttribute("testWithQuestions", super.getWithQuestions(getId(request)));
        return "testsQuestions";
    }

    @GetMapping("/users/add")
    public String addUsers(HttpServletRequest request, ModelMap map) {
        if (request.getParameter("user") != null) {
            super.addUser(getId(request), super.getUser(getUser(request)));
        }
        map.addAttribute("students", super.getWithoutTestUsers(getId(request)));
        map.addAttribute("test", super.get(getId(request)));
        return "addStudents";
    }

    @GetMapping("/users/delete")
    public String deleteUserFromTest(HttpServletRequest request, ModelMap map) {
        super.removeUser(getId(request), super.getUser(getUser(request)));
        map.addAttribute("testId", super.get(getId(request)).getId());
        map.addAttribute("testWithUsers", super.getWithUsers(getId(request)));
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

    private int getQuestion(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("question"));
        return Integer.parseInt(paramId);
    }

    public String addTChar(String str) {
        return str.substring(0, 10) + 'T' + str.substring(11);
    }
}
