package ru.learnup.task21.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectLogMethod {
    private static final Logger LOG = LoggerFactory.getLogger(AspectLogMethod.class);

    @AfterReturning(value = "@annotation(ru.learnup.task21.aspects.LogMethod)", returning = "object")
    public void beforeLogMethod(JoinPoint joinPoint, Object object) {
        LOG.info("LogMethod: method - {}", joinPoint.getSignature().getName());
        LOG.info("LogMethod: args - {} = [system number, user number]", Arrays.toString(joinPoint.getArgs()));
        LOG.info("LogMethod: answer - {}", object);
    }

}
