package mokito;

/**
 * @author lianghong
 * @date 2019/5/31
 */

public final class FinalClass implements BaseInterface {

    @Override
    public final void finalMethod() {
        System.out.println(finalComments);
    }

    @Override
    public String hello() {
        System.out.println(helloComments);
        return "Hello!";
    }

}
