package aop.soundsystem;

import aop.Encoreable;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Component
public class DefaultEncoreable implements Encoreable{

    @Override
    public void performEncore() {
        System.out.println("default encore performance!");
    }
}
