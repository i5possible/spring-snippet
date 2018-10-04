package thread.security;

/**
 * @author lianghong
 * @date 03/10/2018
 */

public class OptimizeLock {
    /**
     * 自旋等待
     * 自适应自旋
     * 锁消除 JVM 编译器会自动优化
     * 锁粗化 一系列操作都要加锁/在循环体内加锁
     * 偏向锁 消除无竞争情况下的同步原语
     */
}
