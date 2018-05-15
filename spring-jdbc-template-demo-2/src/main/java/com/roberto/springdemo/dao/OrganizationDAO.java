/**
 * @author Roberto Affonso Araújo
 *
 */
package com.roberto.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.roberto.springdemo.domain.Organization;

public interface OrganizationDAO {
	
	//Sets the datasource that is required to create a connection to the database;
	public void setDataSource(DataSource ds);
	
	//Create a record in the organization table
	public boolean create(Organization org);
	
	//Retrieve a single organization
	public Organization getOrganization(Integer id);
	
	//Retrive all organizations from the table
	public List<Organization> getAllOrganizations();
	
	//Delete a specific organization
	public boolean delete(Organization org);
	
	//Update a specific organization
	public boolean updateorg(Organization org);
	
	//
	public void cleanup();
}

