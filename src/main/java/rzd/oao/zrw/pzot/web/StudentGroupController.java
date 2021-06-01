package rzd.oao.zrw.pzot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rzd.oao.zrw.pzot.model.Group;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.service.StudentGroupService;
import rzd.oao.zrw.pzot.service.UserGroupService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/studentGroups", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentGroupController {
    private final StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping("/{id}")
    public Group get(@PathVariable int id) {
        return studentGroupService.get(id);
    }

    @GetMapping()
    public List<Group> studentGroups() {
        return studentGroupService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> createWithLocation(@RequestBody Group studentGroup) {
        Group created = studentGroupService.create(studentGroup);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/groups/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Group studentGroup, @PathVariable int id) {
        // Id проверить в сервисе AssureIdConsist
        studentGroupService.update(studentGroup);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studentGroupService.delete(id);
    }

}
