package beans.other;

import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 27/01/2018
 */

@Component
public class AwesomeBean {
    private String name;

    private String desc;

    public AwesomeBean() {
        System.out.println("AwesomeBean Created!");
    }
}
