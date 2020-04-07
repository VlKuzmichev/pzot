package rzd.oao.zrw.pzot;

import rzd.oao.zrw.pzot.model.User;
import rzd.oao.zrw.pzot.model.UserGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static rzd.oao.zrw.pzot.UserTestData.*;

public class UserGroupTestData {
    public static final Integer USER_GROUP_ID = 100000;

    public static final UserGroup USER_GROUP = new UserGroup(USER_GROUP_ID, "All");
    public static final UserGroup USER_GROUP2 = new UserGroup(USER_GROUP_ID + 1, "St mechaniks");
    public static final UserGroup USER_GROUP3 = new UserGroup(USER_GROUP_ID + 2, "Mechaniks");
    public static final UserGroup USER_GROUP4 = new UserGroup(USER_GROUP_ID + 3, "Specialists");
    public static final UserGroup NEW_USER_GROUP = new UserGroup(null, "New group");

    public static List<User> getUsers(){
        List<User> list = new ArrayList<>();
        list.add(USER);
        list.add(EXAMINER);
        list.add(ADMIN);
        return list;
    }

}
