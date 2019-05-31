package mokito;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lianghong
 * @date 2019/5/31
 */

public class NormalClass implements BaseInterface {
    private String name;

    private DependedClass dependedClass;

    public NormalClass() {
    }

    @Autowired
    public NormalClass(DependedClass dependedClass) {
        this.dependedClass = dependedClass;
    }

    public static void staticMethod() {
        System.out.println(staticComments);
    }

    @Override
    public final void finalMethod() {
        dependedClass.doSomething();
        System.out.println(finalComments);
    }

    @Override
    public String hello() {
        boolean result = dependedClass.doSomething();
        System.out.println(helloComments);
        return "Hello!" + result;
    }

    public String getSomething() {
        return DependedClass.getSomething();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DependedClass getDependedClass() {
        return dependedClass;
    }

    public void setDependedClass(DependedClass dependedClass) {
        this.dependedClass = dependedClass;
    }

}
