package enumcollection;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author lianghong
 * @date 2019/5/15
 */

public class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public void appStyles(Set<Style> styles) {
        styles.forEach(s -> System.out.println("Apply Style:" + s.name()));
    }

    public static void main(String[] args) {
        new Text().appStyles(EnumSet.of(Style.BOLD, Style.STRIKETHROUGH));
    }
}
