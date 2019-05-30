package serialization;

/**
 * @author lianghong
 * @date 2019/5/4
 */

//public class SerializationProxy<E extends Enum<E>> implements Serializable{
//    private final Class<E> elementType;
//    private final Enum[] elements;
//
//    SerializationProxy(EnumSet<E> set) {
//        elementType = set.elementType;
//        elements = set.toArray(EMPTY_ENUM_ARRAY);
//    }
//
//    private Object readResolve() {
//        EnumSet<E> result = EnumSet.noneOf(elementType);
//        for (Enum e: elements) {
//            result.add((E)e);
//        }
//        return result;
//    }
//
//    private static final long serialVersionUID = -1;
//}
