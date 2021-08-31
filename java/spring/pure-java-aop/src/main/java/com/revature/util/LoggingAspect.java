package com.revature.util;

import com.revature.models.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingAspect implements InvocationHandler {

    private Service service;

    public LoggingAspect(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("Method %s invoked at %s\n", method.getName(), LocalDateTime.now()); // similar to @Before advice
        Object returnedObject = method.invoke(service, args); // The actual invocation of the original/advised method
        System.out.printf("Method %s returned at %s with value: %s\n", method.getName(), LocalDateTime.now(), returnedObject); // similar to @AfterReturning advice
        return returnedObject;
    }

}
