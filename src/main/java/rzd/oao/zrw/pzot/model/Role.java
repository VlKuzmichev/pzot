package rzd.oao.zrw.pzot.model;

//import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.GrantedAuthority;

public enum Role  implements GrantedAuthority {
    ROLE_USER,
    ROLE_EXAMINER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}