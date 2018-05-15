package com.roberto.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roberto.springdemo.domain.HumanResourceDept;
import com.roberto.springdemo.domain.Organization;

/**
 * @author Roberto Affonso
 *
 */
public class DIConstructorApp
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
//		System.out.println(org);
//		
//		System.out.println(org.businessService());
		
		HumanResourceDept hrdept = (HumanResourceDept) ctx.getBean("myhrdept");
		System.out.println(hrdept.hiringStatus(5500));
		
		//close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
