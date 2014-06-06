package com.ciandt.arqref.framework.logging;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

/**
 * This class implements the BeanPostProcessor interface
 * to inject a org.slf4j.logger object on all fields with an
 * @log annotation on it. 
 */
public class LogPostProcessor implements BeanPostProcessor {

	/**
	 * This method is called after managed bean is initialized.
	 * It will return a bean instance with a org.slf4j.Logger object 
	 * injected on the all fields annotated with @log annotation.
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
		return bean;
	}

	/**
	 * This method is called before any managed bean is	initialized.
	 * It will check all bean's field, injecting a org.slf4j.Logger
	 * object in all field annotated with @log. 
	 */
	@Override
	public Object postProcessBeforeInitialization(final Object bean,
			String beanName) {
		ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {

			@Override
			public void doWith(Field field) throws IllegalAccessException {
				ReflectionUtils.makeAccessible(field);
				if (field.getAnnotation(Log.class) != null) {
					Logger logger = LoggerFactory.getLogger(bean.getClass());
					field.set(bean, logger);
				}
			}
		});

		return bean;
	}
}
