package beans.auto.office;

import beans.auto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Component
public class MasterOffice {
    @Autowired
    @Qualifier("master")
    private User master;

    @Autowired
    private User member;

    public User getMaster() {
        return master;
    }

    public User getMember() {
        return member;
    }
}
