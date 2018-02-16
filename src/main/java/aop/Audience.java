package aop;

import org.aspectj.lang.annotation.*;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Aspect
public class Audience {
    @Pointcut("execution(* aop.Performance.perform(..))")
    public void performance() { }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before(value = "execution(* aop.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking Seats");
    }

    @AfterReturning(value = "execution(* aop.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("execution(* aop.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
