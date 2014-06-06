package com.ciandt.arqref.framework.logging;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation for Logger field.
 * It is target to FIELD elements and retention on RUNTIME.
 */
@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface Log {
}
