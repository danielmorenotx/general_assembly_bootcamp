package com.example.ecommerce.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect // turns this into an aspect which spies on other classes
@Component // creates a bean of this class
public class LoggingAspect {

    @Pointcut("execution(* com.example.ecommerce.controller..*.*(..))") // create proxy inside this package
    public void controllerMethods() {} // spy on controller class in package

    @Before("controllerMethods()") // before any methods in controllers are run
    public void logBeforeMethod(JoinPoint joinPoint) { // log this info for me
        log.info("Before method: " + joinPoint.getSignature().toShortString() + "; Trigger time: " + System.currentTimeMillis());
        // joinPoint says to get any method
        // get signature returns the method signature
        // if it's long, .toShorString shortens it
    }

    @After("controllerMethods()") // after any methods are run
    public void logAfterMethod(JoinPoint joinPoint) { // log this info for me
        log.info("After method: " + joinPoint.getSignature().toShortString() + "; Trigger time: " + System.currentTimeMillis());
    }


}
