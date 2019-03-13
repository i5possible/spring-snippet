package basic.state;

import org.apache.commons.lang3.Validate;

/**
 * @author lianghong
 * @date 2019/3/13
 */

public enum UpdateState {
    UPDATEABLE(() -> Validate.validState(true)),
    READONLY(() -> Validate.validState(false));

    private Runnable action;

    UpdateState(Runnable action) {
        this.action = action;
    }

    public <T> T set(T value) {
        action.run();
        return value;
    }
}
