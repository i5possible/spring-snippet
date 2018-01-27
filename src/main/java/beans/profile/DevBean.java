package beans.profile;

import org.springframework.context.annotation.Profile;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Profile("dev")
public class DevBean {
    public DevBean() {
        System.out.println("DevBean Created!");
    }
}
