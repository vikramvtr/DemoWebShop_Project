package com.qsp.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	
	@FindBy(id = "RememberMe")
	private WebElement remeberMeCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	private WebElement forgetPasswordLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButtonLoginPage;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getRemeberMeCheckBox() {
		return remeberMeCheckBox;
	}

	public WebElement getForgetPasswordLink() {
		return forgetPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRegisterButtonLoginPage() {
		return registerButtonLoginPage;
	}
	
	


}
