package beans.auto.user.impl;

import beans.auto.user.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Component(value = "master")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Master implements User {
}
