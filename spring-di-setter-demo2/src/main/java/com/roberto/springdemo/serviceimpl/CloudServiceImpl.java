package com.roberto.springdemo.serviceimpl;

import java.util.Random;

import com.roberto.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService
{

	public String offerService(String companyName)
	{
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName +
				" offers world class cloud computing infrastructure." +
				"\nThe annual income exceeds: " + random.nextInt(revenue) + 
				" Dollars";
		return service;
	}

}
