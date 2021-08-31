package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect // this designates this class as an aspect to the AspectJWeaver dependency
@Component // this designates this class as a component to be managed by Spring
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger();

    @Pointcut("within(com.revature..*)") // Pointcut Expression Language (PEL); a predicate matching to a "join point"
    public void logAll() { }


    // Aspect methods encapsulate "advice" logic
    @Before("logAll()")
    public void logMethodStart(JoinPoint jp) {

        // The JoinPoint object represents the point in which we are injecting this advice logic
        String methodSig = extractMethodSignature(jp);
        String argStr = Arrays.toString(jp.getArgs());
        logger.info("{} invoked at {}", methodSig, LocalDateTime.now());
        logger.info("Input arguments: {}", argStr);

    }

    @AfterReturning(pointcut = "logAll()", returning = "returnedObj")
    public void logMethodReturn(JoinPoint jp, Object returnedObj) {
        String methodSig = extractMethodSignature(jp);
        logger.info("{} successfully returned at {}", methodSig, LocalDateTime.now());
        logger.info("Object returned: {}", returnedObj);
    }

    @AfterThrowing(pointcut = "logAll()", throwing = "e")
    public void logMethodException(JoinPoint jp, Throwable e) {
        String methodSig = extractMethodSignature(jp);
        String exceptionName = e.getClass().getSimpleName();
        logger.warn("{} was thrown in method {} at {} with message: {}", exceptionName, methodSig, LocalDateTime.now(), e.getMessage());
    }


    // This is not an advice method, this is just a helper.
    private String extractMethodSignature(JoinPoint jp) {
        return jp.getTarget().getClass().toString() + "#" + jp.getSignature().getName(); // com.revature.FootballCoach#getTeamName
    }

}
