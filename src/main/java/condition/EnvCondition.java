package condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lianghong
 * @date 27/01/2018
 */

public class EnvCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return annotatedTypeMetadata.isAnnotated("org.springframework.beans.factory.annotation.Qualifier");
    }
}
