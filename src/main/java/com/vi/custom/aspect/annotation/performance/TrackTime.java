package com.vi.custom.aspect.annotation.performance;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
    String headName() default "HEAD_NAME";

    String subHeadName() default "SUB_HEAD_NAME";
}
