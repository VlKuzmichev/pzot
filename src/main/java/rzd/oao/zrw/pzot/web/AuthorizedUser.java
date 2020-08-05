package rzd.oao.zrw.pzot.web;

import rzd.oao.zrw.pzot.model.User;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    private User authUser;

    public AuthorizedUser(User user) {
        super(user.getName(), user.getPassword(), user.getRoles());
        this.authUser = user;
    }

    public User getUser() {
        return authUser;
    }

    public int getId() {
        return authUser.getId();
    }

}
