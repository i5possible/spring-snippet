package concurrency.confinement;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.*;

/**
 * Collections.synchronizedList(list) is a instance confinement example.
 * Decorator.
 * @author lianghong
 * @date 2019/3/13
 */

@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containsPerson(Person person) {
        return mySet.contains(person);
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        List<Object> objects1 = Collections.synchronizedList(objects);
        objects.iterator();
        for (Object o : objects1) {
            o.toString();
        }
    }

    private class Person {

    }
}
