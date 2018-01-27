package beans.auto;

import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 27/01/2018
 */
@Component
public class MagicBean {
    public MagicBean() {
        System.out.println("MagicBean Created!");
    }
}
