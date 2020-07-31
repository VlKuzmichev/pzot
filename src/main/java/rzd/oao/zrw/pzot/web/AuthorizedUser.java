package rzd.oao.zrw.pzot.web;

import org.springframework.security.core.GrantedAuthority;
import rzd.oao.zrw.pzot.model.User;

import java.util.Collection;

public class AuthorizedUser {// extends org.springframework.security.core.userdetails.User {

    private User authUser;

    //    public AuthorizedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, User user) {
    public AuthorizedUser(User user) {
        this.authUser = user;
    }

    public int getId() {
        return authUser.getId();
    }
}
