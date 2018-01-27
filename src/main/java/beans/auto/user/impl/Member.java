package beans.auto.user.impl;

import beans.auto.user.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Component(value = "member")
@Primary
public class Member implements User {
}
