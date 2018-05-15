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

public class JdbcTemplateClassicApp2 {

	public static void main(String[] args) {
		// Creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		OrganizationDAO dao = (OrganizationDAO) ctx.getBean("orgDao");
		
		// Creating seed data
		DaoUtils.createSeedData(dao);
		
		// List Organizations
		List<Organization> orgs = dao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);
		
		// Create a new organization record
		Organization org = new Organization("General Electric", 1978,  "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.readOperation);
		
		//get a single organization
		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");
		
		//Updating a slogan for an organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("Testing, testing.....");
		boolean isUpdated = dao.updateorg(org3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(org3, DaoUtils.updateOperation);
		
		// Deleting an organization
		Organization org4 = dao.getOrganization(3);
		boolean isDeleted = dao.delete(org4);
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		
		
		// Cleanup
		dao.cleanup();
		DaoUtils.printOrganizations(dao.getAllOrganizations(), DaoUtils.cleanupOperation);
		
		// Closing the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}
}

