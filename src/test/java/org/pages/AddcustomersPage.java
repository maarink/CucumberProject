package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomersPage {
	WebDriver driver;

	public AddcustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p")
	private WebElement ClickCustomerBtn;

	@FindBy(xpath = "//p[text()=' Customers']")
	private WebElement ClickCustomerBtn1;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement addNewBtn;

	@FindBy(id = "Email")
	private WebElement txtuserName;

	@FindBy(id = "Password")
	private WebElement txtPassword;

	@FindBy(id = "FirstName")
	private WebElement txtFname;

	@FindBy(id = "LastName")
	private WebElement txtLname;

	@FindBy(id = "Gender_Male")
	private WebElement gender_Male;

	@FindBy(id = "DateOfBirth")
	private WebElement dob;

	@FindBy(id = "Company")
	private WebElement companyName;

	@FindBy(id = "VendorId")
	private WebElement vendorId;

	@FindBy(id = "AdminComment")
	private WebElement adminComment;
	
	@FindBy(name = "save")
	private WebElement saveBtn;
//==============================================
	public String getTitlepage() {
		return driver.getTitle();
		
	}
	public void ClickCustomerBtn() {
		ClickCustomerBtn.click();
	}

	public void ClickCustomerBtn1() {
		ClickCustomerBtn1.click();
	}

	public void addNewBtn() {
		addNewBtn.click();
	}

	public void setEmail(String email) {
		txtuserName.sendKeys(email);
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	public void setFname(String fName) {
		txtFname.sendKeys(fName);
	}

	public void setLname(String lName) {
		txtLname.sendKeys(lName);
	}

	public void gender() {
		gender_Male.click();
	}

	public void dob(String dofb) {
		dob.sendKeys(dofb);
	}

	public void companyName(String cName) {
		companyName.sendKeys(cName);
	}

	public void mVendorId (String vendor) {
		Select s = new Select(vendorId);
		s.selectByVisibleText(vendor);
	}

	public void adminComment(String comment) {
		adminComment.sendKeys(comment);
	}
	public void saveBtt() {
		saveBtn.click();
	}
}
