package com.roberto.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml");
		City city = (City) ctx.getBean("citybean");
		city.getName();
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
