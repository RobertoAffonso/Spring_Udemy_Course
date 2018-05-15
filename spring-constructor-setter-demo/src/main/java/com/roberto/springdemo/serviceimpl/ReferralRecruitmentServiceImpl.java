package com.roberto.springdemo.serviceimpl;

import java.util.Random;

import com.roberto.springdemo.service.RecruitmentService;

public class ReferralRecruitmentServiceImpl implements RecruitmentService
{

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments)
	{
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'S " + departmentName + " hired "
				+ random.nextInt(numberOfRecruitments) + " employees "
				+ "which were reffered to the companies by employees.";
		return hiringFacts;
	}

}
