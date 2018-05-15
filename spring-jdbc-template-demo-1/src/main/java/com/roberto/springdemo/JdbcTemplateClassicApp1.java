/**
 * @author Roberto Affonso Araújo
 *
 */
package com.roberto.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roberto.springdemo.dao.OrganizationDAO;
import com.roberto.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {

	public static void main(String[] args) {
		// Creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		OrganizationDAO dao = (OrganizationDAO) ctx.getBean("orgDao");
		List<Organization> orgs = dao.getAllOrganizations();
		for(Organization org : orgs) {
			System.out.println(org.getSlogan());
		}
		
		// Closing the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}
}

