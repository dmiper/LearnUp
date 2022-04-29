package ru.learnup.task21.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectWorkTime {
    private static final Logger LOG = LoggerFactory.getLogger(AspectWorkTime.class);

    @Around(value = "@annotation(ru.learnup.task21.aspects.WorkTime)")
    public Object aroundWorkTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long time = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis() - time;
        LOG.info("WorkTime: method - " + joinPoint.getSignature().getName());
        LOG.info("WorkTime: took time - {}ms", end);
        return object;
    }
}
