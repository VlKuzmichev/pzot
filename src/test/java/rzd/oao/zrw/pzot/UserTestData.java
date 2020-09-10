package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.Role;
import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.ArrayList;
import java.util.List;

import static rzd.oao.zrw.pzot.UserGroupTestData.USER_GROUP;

public class UserTestData {
    public static final Integer USER_ID = 100004;
    public static final Integer EXAMINER_ID = 100005;
    public static final Integer ADMIN_ID = 100006;

    public static final User USER = new User(USER_ID, "User", "{noop}password", "user@yandex.ru",
            "Ivanov Ivan Ivanovich", Role.ROLE_USER);
    public static final User EXAMINER = new User(EXAMINER_ID, "Exam", "{noop}password2", "exam@yandex.ru",
            "Petrov Peter Petrovich", Role.ROLE_EXAMINER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "{noop}password3", "admin@yandex.ru",
            "Adminov Admin Adminovich", Role.ROLE_ADMIN);

//    public static final User NEW_USER = new User(USER_ID+16, "NewUser", "password4", "newuser@yandex.ru",
//            "Created User Userovich", Role.ROLE_USER);

    public static User getCreated() {
        User user = new User(null, "NewUser", "password4", "newuser@yandex.ru",
                "Created User Userovich", Role.ROLE_USER);
        return user;
    }

    public static List<UserGroup> getUserGroups(){
        List<UserGroup> groupList = new ArrayList<>();
//        groupList.add(new UserGroup(100000, "All"));
        groupList.add(USER_GROUP);
        return groupList;
    }
}
