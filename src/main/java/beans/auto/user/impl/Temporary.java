package beans.auto.user.impl;

import beans.auto.user.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Component(value = "temporary")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class Temporary implements User {
}
