package com.ciandt.arqref.ordermanager.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:META-INF/spring/applicationContext-aop.xml",
		"classpath:META-INF/spring/applicationContext-ehcache.xml",
		"classpath:META-INF/spring/testContext-foundation.xml",
		"classpath:META-INF/spring/applicationContext-mail.xml",
		"classpath:META-INF/spring/testContext-database.xml" })
public abstract class OrderManagementAbstractTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Before
	public final void init() {
		MockitoAnnotations.initMocks(this);
	}
	
}
