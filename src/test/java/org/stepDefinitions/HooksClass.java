package org.stepDefinitions;

import org.Base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass{

	@Before
	public void beforeScenario() {
		browserLaunch("chrome");
		launchUrl("https://admin-demo.nopcommerce.com/");
		maximize();
		implecitwait();
		System.out.println("------------Before scenario---------");
	}
	
	@After
	public void afterScenario() {
		quit();
		System.out.println("------------After scenario---------");
	}
	
	
	
}
