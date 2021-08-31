package com.revature;

import com.revature.models.Service;
import com.revature.models.UserService;
import com.revature.util.LoggingAspect;

import java.lang.reflect.Proxy;

public class JdkProxyDemo {

    public static void main(String[] args) {

        Service someService = new UserService();
        LoggingAspect loggingAspect = new LoggingAspect(someService);
        Service proxy = (Service) Proxy.newProxyInstance(someService.getClass().getClassLoader(), new Class[] { Service.class }, loggingAspect);
        proxy.foo("Actual method logic!");
    }

}
