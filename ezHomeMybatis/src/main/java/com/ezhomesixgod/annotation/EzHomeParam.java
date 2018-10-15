package com.ezhomesixgod.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EzHomeParam {
    String value() default "";
}
