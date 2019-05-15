package enumcollection;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghong
 * @date 2019/5/15
 */

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID)
        ;
        private final Phase src;
        private final Phase dst;

        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }

        private static final EnumMap<Phase, Map<Phase, Transition>> map =
                new EnumMap<>(Phase.class);

        static {
            for (Phase phase: Phase.values()) {
                map.put(phase, new EnumMap<>(Phase.class));
            }

            for (Transition transition: Transition.values()) {
                map.get(transition.src).put(transition.dst, transition);
            }
        }
    }
}
