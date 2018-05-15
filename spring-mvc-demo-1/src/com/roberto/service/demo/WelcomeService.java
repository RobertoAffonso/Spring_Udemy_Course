package com.roberto.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService
{

	public List<String> getWelcomeMessage(String name)
	{
		List<String> myWelcomeMessages = new ArrayList<>();

		// Adding data to the list
		myWelcomeMessages.add("Hello!");
		myWelcomeMessages.add(name);
		myWelcomeMessages.add(", Welcome to the Spring Course!");

		return myWelcomeMessages;
	}

}
