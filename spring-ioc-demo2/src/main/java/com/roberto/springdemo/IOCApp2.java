package com.roberto.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Roberto Affonso
 *
 */
public class IOCApp2
{

	public static void main(String[] args)
	{
		//create the application context (Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//invoking the bean method
		org.corporateSlogan();
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
