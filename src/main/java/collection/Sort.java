package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lianghong
 * @date 2019/5/1
 */

public class Sort {
    List<String> list = new ArrayList<>();


    /**
     * Adequate for classic OO design patterns, such as Strategy and Command
     */
    public void sort_in_java7() {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    public void sort_in_lambda() {
        Collections.sort(list, (String a, String b) -> Integer.compare(a.length(), b.length()));
    }

    public void sort_in_lambda_using_comparator_construction() {
        Collections.sort(list, Comparator.comparingInt(String::length));
    }

    public void use_sort_method_on_list() {
        list.sort(Comparator.comparingInt(String::length));
    }

}

