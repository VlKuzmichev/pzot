package rzd.oao.zrw.pzot.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rzd.oao.zrw.pzot.model.UserGroup;
import rzd.oao.zrw.pzot.service.UserGroupService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/userGroups", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserGroupController {
    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }
    @GetMapping("/{id}")
    public UserGroup get(@PathVariable String id) {
        return userGroupService.get(Integer.parseInt(id));
    }

    @GetMapping()
    public List<UserGroup> userGroups() {
        return userGroupService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserGroup> createWithLocation(@RequestBody UserGroup userGroup) {
        UserGroup created = userGroupService.create(userGroup);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/userGroups/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserGroup userGroup, @PathVariable int id) {
        // Id проверить в сервисе AssureIdConsist
        userGroupService.update(userGroup);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userGroupService.delete(id);
    }

}
