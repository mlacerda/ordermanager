package com.ciandt.arqref.framework.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This calls contains all methods used by
 * Spring AOP aspects for logging propose.
 * The call for this methods is specified on
 * Application Context file.
 */
public class LogAspect {

	private Logger log = LoggerFactory.getLogger(LogAspect.class);

	/**
	 * This method is called before the execution of the method
	 * intercepted by the Spring AOP aspect.
	 * It will log the method's full name (class and method name)
	 * and all values received as parameter.
	 * @param joinPoint The aspect JointPoint object
	 */
	@SuppressWarnings("rawtypes")
	public void logBefore(JoinPoint joinPoint) {
		if (log.isDebugEnabled()) {
			Class clazz = joinPoint.getTarget().getClass();
			String name = joinPoint.getSignature().getName();
			StringBuilder sb = new StringBuilder();
			sb.append("Getting inside of: ");
			sb.append(clazz.getCanonicalName() + ".");
			sb.append(".");
			sb.append(name);
			sb.append("(");
			Object[] args = joinPoint.getArgs();
			for (Object o : args) {
				sb.append(o);
				sb.append(",");
			}
			sb.append(");");
			log.debug(sb.toString());
		}
	}

	/**
	 * This method is called after the intercepted method's execution ends.
	 * It will log the method's full name (class and method name) and
	 * the value returned by the method.
	 * @param joinPoint JoinPoint object
	 * @param result Result object
	 */
	@SuppressWarnings("rawtypes")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		if (log.isDebugEnabled()) {
			Class clazz = joinPoint.getTarget().getClass();
			String name = joinPoint.getSignature().getName();
			StringBuilder sb = new StringBuilder();
			sb.append("Leaving method: " + clazz.getName() + "." + name);

			if (joinPoint.getSignature() instanceof MethodSignature) {
				MethodSignature signature = (MethodSignature) joinPoint
						.getSignature();
				Class returnType = signature.getReturnType();
				if (returnType.getName().compareTo("void") == 0) {
					sb.append("Returnig void: ");
					sb.append(result);
					log.debug(sb.toString());
					return;
				}
			}

			sb.append("Returning Value(s): ");
			for (Object o : joinPoint.getArgs()) {
				sb.append(o);
			}
			log.debug(sb.toString());
		}
	}

	/**
	 * This method is called if the method intercepted by the 
	 * Spring AOP aspect throws any exception, logging the error code
	 * and message and all StackTrace.
	 * @param joinPoint The JointPoint object
	 * @param error Throwable object
	 */
	@SuppressWarnings("rawtypes")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		Class clazz = joinPoint.getTarget().getClass();
		String name = joinPoint.getSignature().getName();
		StringBuilder sb = new StringBuilder();
		sb.append("Exception was thrown from: " + clazz.getName() + "." + name);
		sb.append("(");
		for (Object o : joinPoint.getArgs()) {
			sb.append(o);
		}
		sb.append(")");
		sb.append("\r\n");
		sb.append("Exception message: ");
		sb.append(error.getMessage());
		sb.append("\r\n");
		sb.append("Execution stacktrace: ");
		sb.append(this.getStackTrace(error));
		log.error(sb.toString());
	}

	/**
	 * This method return the StackTrace as String.
	 * @param throwable Exception object
	 * @return String with all StackTrace
	 */
	private String getStackTrace(Throwable throwable) {
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		throwable.printStackTrace(printWriter);
		return writer.toString();
	}

}
