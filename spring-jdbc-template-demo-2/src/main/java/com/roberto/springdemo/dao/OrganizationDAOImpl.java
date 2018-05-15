/**
 * 
 * @author Roberto Affonso Araújo
 *
 */
package com.roberto.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roberto.springdemo.daoimpl.OrganizationRowMapper;
import com.roberto.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDAOImpl implements OrganizationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public boolean create(Organization org) {
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
						  "VALUES(?, ?, ?, ?, ?)";
		Object[] args = new Object[] { org.getCompanyName(),
									   org.getYearOfIncorporation(),
									   org.getPostalCode(),
									   org.getEmployeeCount(),
									   org.getSlogan()
									   };
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan " +
		"FROM organization WHERE id = ?";
		Object[] args = new Object[] {id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		
		return orgList;
	}

	public boolean delete(Organization org) {
		String sqlQuery = "DELETE FROM organization WHERE id = ?";
		Object[] args = new Object[] {org.getId()};
		return jdbcTemplate.update(sqlQuery, args) ==1;
	}

	public boolean updateorg(Organization org) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] {org.getSlogan(), org.getId()};
		return jdbcTemplate.update(sqlQuery, args) ==1;
	}

	public void cleanup() {
		// TODO Auto-generated method stub

	}

//	public boolean updateorg(Organization org) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}

