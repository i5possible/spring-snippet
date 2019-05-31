package mokito;

/**
 * @author lianghong
 * @date 2019/5/31
 */

public interface BaseInterface {
    String staticComments = "Static method is called!";
    String finalComments = "Final method is called!";
    String helloComments = "Hello method is called!";

    void finalMethod();

    String hello();


}
