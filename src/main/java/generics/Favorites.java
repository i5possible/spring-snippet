package generics;

import java.util.HashMap;
import java.util.Map;

/**
 * 不能用在不可具化的类型中，比如List
 * @author lianghong
 * @date 2019/5/2
 */

public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();
    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        Object o = favorites.get(type);
        return type.cast(o);
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "String");
        favorites.putFavorite(Integer.class, 10);

        String s = favorites.getFavorite(String.class);
        Integer i = favorites.getFavorite(Integer.class);

        System.out.println(s + " is: " + i);
    }
}
