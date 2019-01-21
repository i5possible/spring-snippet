package openid;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;

import java.util.Collection;
import java.util.List;

/**
 * @author lianghong
 * @date 21/01/2019
 */

public class OpenIdOP {
    public static void main(String[] args) {
        OpenIDAuthenticationToken token =
                (OpenIDAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        List<OpenIDAttribute> attributes = token.getAttributes();
        Object credentials = token.getCredentials();
        String identityUrl = token.getIdentityUrl();
        String message = token.getMessage();
        Object principal = token.getPrincipal();
        OpenIDAuthenticationStatus status = token.getStatus();
        boolean authenticated = token.isAuthenticated();
        Collection<GrantedAuthority> authorities = token.getAuthorities();

    }
}
