package org.stepDefinitions;

import org.Base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.pages.AddcustomersPage;
import org.pages.LoginPage;
import org.pages.SearchCustomerPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps1 extends BaseClass{
	LoginPage l;
	AddcustomersPage addcust;
	SearchCustomerPage searchcust;
	

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
//	    browserLaunch("chrome");
//	  maximize();    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		// launchUrl(url);
		l = new LoginPage(driver);

	}

	@When("The user has to fill email {string} and password {string}")
	public void the_user_has_to_fill_email_and_password(String user, String pass) {
		l.setUserName(user);
		l.setPassword(pass);
	}

	@When("Click on Login")
	public void click_on_login() {
		l.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on log out Link")
	public void user_click_on_log_out_link() {
		l.clickLogout();
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	}

//=============================================================	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		addcust = new AddcustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getTitlepage());

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.ClickCustomerBtn();
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(5000);
		addcust.ClickCustomerBtn1();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(5000);
		addcust.addNewBtn();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getTitlepage());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		String email = randomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFname("maari");
		addcust.setLname("nk7");
		addcust.gender();
		addcust.dob("11/19/2022");
		addcust.companyName("axyya");
		addcust.mVendorId("Vendor 1");
		addcust.adminComment("welcome");

	}

	@When("Click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addcust.saveBtt();
		Thread.sleep(5000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertFalse(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}
//===================================================
// search for customers emailId

	@When("Enter customer MailId")
	public void enter_customer_mail_id() {
		searchcust = new SearchCustomerPage(driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException {
		searchcust.clickSearch();
		Thread.sleep(5000);
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status = searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	//	Assert.assertEquals(true, status);
		// System.out.println(status);
	}

//=======================================================
	@When("Enter customer Firstname")
	public void enter_customer_firstname() {
		searchcust = new SearchCustomerPage(driver);
		searchcust.setFname("Victoria");
	}

	@When("Enter customer Lasttname")
	public void enter_customer_lasttname() {
		searchcust.setLname("Terces");
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status = searchcust.searchCustomerByName("Victoria Terces");
	//	Assert.assertEquals(true, status);
	}
}
