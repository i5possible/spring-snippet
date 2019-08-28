package excel;

import lombok.Builder;
import lombok.Data;

/**
 * @author lianghong
 * @date 2019/8/28
 */

@Builder
@Data
public class User {
    String name;
    String email;
    String phone;
}
