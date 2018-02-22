package aop;

import aop.soundsystem.DefaultEncoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author lianghong
 * @date 16/02/2018
 */

@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value = "aop.soundsystem.CompactDisc+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
