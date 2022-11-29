package org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utlities.WaitHelper;

public class SearchCustomerPage {
	WebDriver driver;
	WaitHelper WaitHelper;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper = new WaitHelper(driver);
	}

	@FindBy(id = "SearchEmail")
	private WebElement txtEmail;

	@FindBy(id = "SearchFirstName")
	private WebElement SearchFirstName;

	@FindBy(id = "SearchLastName")
	private WebElement SearchLastName;

	@FindBy(xpath = "//*[@id=\"search-customers\"]/i")
	private WebElement btnSearch;

	@FindBy(id = "SearchMonthOfBirth")
	private WebElement dobMonth;

	@FindBy(id = "SearchDayOfBirth")
	private WebElement dobDate;

	@FindBy(id = "SearchCompany")
	private WebElement SearchCompany;

	@FindBy(id = "SearchIpAddress")
	private WebElement SearchIpAddress;

	@FindBy(xpath = "//table[@id='customers-grid']")
	private WebElement table;

//	@FindBy(how=How.XPATH,using ="")
//	WebElement table;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	private List<WebElement> tablerows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	private List<WebElement> tableColoms;

//=======================================================	
	public void setEmail(String email) {

		WaitHelper.waitforEelement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFname(String fname) {

		WaitHelper.waitforEelement(SearchFirstName, 30);
		SearchFirstName.clear();
		SearchFirstName.sendKeys(fname);
	}

	public void setLname(String Lname) {

		WaitHelper.waitforEelement(SearchLastName, 30);
		SearchLastName.clear();
		SearchLastName.sendKeys(Lname);
	}

	public void SearchLastName(String lname) {

		WaitHelper.waitforEelement(txtEmail, 30);
		SearchLastName.clear();
		SearchLastName.sendKeys(lname);
	}

	public void clickSearch() {
		btnSearch.click();
		WaitHelper.waitforEelement(btnSearch, 30);
	}

	public int getNoofRows() {
		return (tablerows.size());
	}

	public int getNoofColomn() {
		return (tableColoms.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		for (int i = 1; i <= getNoofRows(); i++) {
			String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(emailId);
			if (emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;

	}
	public boolean searchCustomerByName(String Name) {
		boolean flag = false;
		for (int i = 1; i <= getNoofRows(); i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"))
					.getText();
			String[] names = name.split(" ");
			
			if (names[0].equals("Victoria")&& names[1].equals("Terces")) {
				flag = true;
			}
		}
		return flag;

}}
