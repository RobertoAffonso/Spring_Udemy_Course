package com.roberto.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App2
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new FileSystemXmlApplicationContext("bean-config.xml");
		City city = (City) ctx.getBean("citybean");
		city.getName();
		((FileSystemXmlApplicationContext) ctx).close();
		
	}
}
