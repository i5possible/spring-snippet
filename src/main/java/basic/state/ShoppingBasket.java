package basic.state;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghong
 * @date 2019/3/13
 */

public class ShoppingBasket {
    private String orderNo;
    private List<String> articleNumbers = new ArrayList<>();
    private UpdateState state = UpdateState.UPDATEABLE;

    public void add(String articleNumber) {
        articleNumbers.add(state.set(articleNumber));
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = state.set(orderNo);
    }

    public void order() {
        // 实现订单逻辑，如果下单成功，应改变订单状态
        state = UpdateState.READONLY;
    }

    public static void main(String[] args) {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.add("001");
        shoppingBasket.add("002");
        shoppingBasket.order();
        shoppingBasket.add("003");
    }
}
