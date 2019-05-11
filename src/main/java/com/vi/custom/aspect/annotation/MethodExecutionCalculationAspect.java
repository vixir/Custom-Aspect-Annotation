package com.vi.custom.aspect.annotation;

import com.vi.custom.aspect.annotation.performance.*;
import lombok.extern.slf4j.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.*;
import org.springframework.core.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@Aspect
@Slf4j
public class MethodExecutionCalculationAspect {

    @Around("@annotation(com.vi.custom.aspect.annotation.performance.TrackTime)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed;
        long startTime = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        TrackTime trackTime = AnnotationUtils.findAnnotation(methodSignature.getMethod(), TrackTime.class);
        Map<String, Object> map = AnnotationUtils.getAnnotationAttributes(trackTime);
        String headName = (String) map.get("headName");
        String subHeadName = (String) map.get("subHeadName");
        try {
            proceed = proceedingJoinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("Time Taken by head {}, subHead {} and joinPoint {} returned with value {}",
                    headName,
                    subHeadName,
                    proceedingJoinPoint,
                    endTime - startTime);
        }
        return proceed;
    }
}
