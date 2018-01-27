package beans.always;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 27/01/2018
 */
@Component
public class BasicBean {
    public BasicBean() {
        System.out.println("BasicBean Constructor!");
    }
}
