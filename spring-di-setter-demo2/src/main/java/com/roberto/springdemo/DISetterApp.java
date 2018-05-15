package com.roberto.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roberto.springdemo.domain.Organization;

/**
 * @author Roberto Affonso
 *
 */
public class DISetterApp
{

	public static void main(String[] args)
	{
		//create the application context (Container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//invoking the bean method
		System.out.println(org.corporateSlogan());
		
		//Print organization details
		System.out.println(org);
		
		System.out.println(org.businessService());
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
