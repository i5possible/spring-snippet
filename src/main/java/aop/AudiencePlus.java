package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Aspect
public class AudiencePlus {
    @Pointcut("execution(* aop.Performance.perform(..))")
    public void performance() { }

    @Around("performance()")
    public void silenceCellPhones(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking Seats!");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            System.out.println("Silencing cell phones");
        }
    }

}
