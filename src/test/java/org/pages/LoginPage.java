package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="Email")
		private WebElement txtusername;
		
		@FindBy(id="Password")
		private WebElement txtpassword;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement loginBtn;
		
		@FindBy(xpath="//a[text()='Logout']")
		private WebElement lnklogout;
		

		
		public void setUserName(String uname) {
			txtusername.clear();
			txtusername.sendKeys(uname);
		}
		
		public void setPassword(String pwd) {
			txtpassword.clear();
			txtpassword.sendKeys(pwd);
		}
		
		public void clickLogin() {
			loginBtn.click();
		}
		
		public void clickLogout() {
			lnklogout.click();
		}
}
