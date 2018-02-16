package aop;

/**
 * @author lianghong
 * @date 16/02/2018
 */

/**
 *
 * execution(* concert.Performance.perform(..))
 * execution: triggered at the method execution
 * *: any return type
 * concert.Performance: the class including the method
 * perform: the method
 * (..) any args
 *
 * execution(* concert.Performance.perform(..)) && within(concert.*)
 * execution(* concert.Performance.perform(..)) and within(concert.*)
 * execution(* concert.Performance.perform(..)) and bean('woodstock')
 * execution(* concert.Performance.perform(..)) and !bean('woodstock')
 */
public interface Performance {
    void perform();
}
